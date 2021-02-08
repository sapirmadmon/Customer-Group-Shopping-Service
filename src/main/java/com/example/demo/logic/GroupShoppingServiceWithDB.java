package com.example.demo.logic;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.boundaries.GroupBoundary;
import com.example.demo.boundaries.User;
import com.example.demo.consumers.ProductBasedShoppingProductsService;
import com.example.demo.consumers.UserBasedUserManagementService;
import com.example.demo.converters.GroupConverter;
import com.example.demo.dal.GroupDao;
import com.example.demo.data.GroupEntity;
import com.example.demo.exceptions.EmptyProductException;
import com.example.demo.exceptions.GroupNotFoundException;
import com.example.demo.exceptions.InvalidDiscountException;
import com.example.demo.exceptions.InvalidEmailException;
import com.example.demo.exceptions.InvalidProdQuantityException;
import com.example.demo.exceptions.InvalidValidityException;
import com.example.demo.validator.Validator;

@Service
public class GroupShoppingServiceWithDB implements GroupShoppingService{
	private GroupDao groupDao;
	private GroupConverter converter;
	private Validator validator;
	private UserBasedUserManagementService userBasedUserManagement;
	private ProductBasedShoppingProductsService productBasedProductsManagement;

	@Autowired
	public GroupShoppingServiceWithDB(GroupDao groupDao) {
		super();
		this.groupDao = groupDao;
	}

	@Autowired
	public void setConverter(GroupConverter converter) {
		this.converter = converter;
	}

	@Autowired
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Autowired
	public void setUserBasedUserManagement(UserBasedUserManagementService userBasedUserManagement) {
		this.userBasedUserManagement = userBasedUserManagement;
	}

	@Autowired
	public void setProductBasedProductsManagement(ProductBasedShoppingProductsService productBasedProductsManagement) {
		this.productBasedProductsManagement = productBasedProductsManagement;
	}

	
	@Override
	public GroupBoundary createGroup(GroupBoundary group) {

		//Check if the email is OK
		if (!this.validator.validateUserEmail(group.getGroupInitiator().getEmail())) {
			throw new InvalidEmailException("Email of initiator must be in the format of example@example.com");
		} 

		//Check if the user (initiator) is in the User Management System
		try {
			userBasedUserManagement.getUserFromUserManagement(group.getGroupInitiator().getEmail());
		} catch (Exception e) {
			throw new InvalidEmailException("Email of initiator: " + group.getGroupInitiator().getEmail() + " does not exist in the system");
		}


		//Check if the product ID is not null
		if(group.getProduct().getProductId() == null) {
			throw new EmptyProductException("The product ID is empty");
		}

		//Check if the product id is in the Product Management System
		try {
			productBasedProductsManagement.getProductFromShoppingProductsManagement(group.getProduct().getProductId());
		} catch (Exception e) {
			throw new EmptyProductException("The product does not exist in the system");
		}


		for(User u:group.getMembers()) {
			if(!(this.validator.validateUserEmail(u.getEmail())))
				throw new InvalidEmailException("Email of member: " +  u.getEmail() + " must be in the format of example@example.com");
			try {
				userBasedUserManagement.getUserFromUserManagement(u.getEmail());
			} catch (Exception e) {
				throw new InvalidEmailException("Email of member: " + u.getEmail() + " does not exist in the system");
			}
		}

		//Check if is discount entered is valid
		if(group.getDiscount() <= 0 || group.getDiscount() > 1) {
			throw new InvalidDiscountException("The discount entered is invalid. The discount should be written in the format: 0.x");
		}
		
		//Check if ProdQuantity is greater than 0
		if(group.getProdQuantity() <= 0) {
			throw new InvalidProdQuantityException("Prod quantity must be greater than 0");
		}
			
		//Check if Group validity is greater than 0
		if(group.getValidity() <= 0) {
			throw new InvalidValidityException("Group validity must be greater than 0");
		}
		
		
		group.setDateOpened(new Date()); //The current date the group was created 
		group.setGroupId(UUID.randomUUID().toString()); //The group number is randomly generated
		group.setNumOfMembers(group.getMembers().size()); //Number of group members is counted by the size of the list members 

		
		GroupEntity savedGroup = this.groupDao.save(this.converter.group_BoundarytoEntity(group));
		return this.converter.group_EntityToBoundary(savedGroup);
	}



	@Override
	public List<GroupBoundary> getAllGroups(int size, int page, String sortAttr, String order) {
		Direction direction = order.equals(Direction.ASC.toString()) ? Direction.ASC : Direction.DESC;
		return this.groupDao.findAll(PageRequest.of(page,size,direction, sortAttr)).stream()
				.map(this.converter::group_EntityToBoundary).collect(Collectors.toList());
	}

	@Override
	public void updateGroup(String groupId, GroupBoundary group) {

		Optional<GroupEntity> groupFromDB = this.groupDao.findById(groupId);
		if (!groupFromDB.isPresent())
			throw new GroupNotFoundException("could not found group by groupId: " + groupId);


		//If a group with the ID was found
		GroupBoundary existingGroup = this.converter.group_EntityToBoundary(groupFromDB.get());

		if(group != null) {

			if(group.getProdQuantity() > 0) {
				existingGroup.setProdQuantity(group.getProdQuantity());
			}

			if(!(group.getMembers().isEmpty())) {
				for(User u:group.getMembers()) {
					if(!(this.validator.validateUserEmail(u.getEmail())))
						throw new InvalidEmailException("Email of member: " +  u.getEmail() + " must be in the format of example@example.com");
					try {
						userBasedUserManagement.getUserFromUserManagement(u.getEmail());
					} catch (Exception e) {
						throw new InvalidEmailException("Email of member: " + u.getEmail() + " does not exist in the system");
					}
				}
				existingGroup.getMembers().addAll(group.getMembers());

				existingGroup.setNumOfMembers(existingGroup.getMembers().size()); //Updated number of group members following the addition of members
			}

		}

		this.groupDao.save(this.converter.group_BoundarytoEntity(existingGroup));
	}


	@Override
	public void deleteAll() {
		this.groupDao.deleteAll();
	}



	@Override
	public List<GroupBoundary> getAllPostsByInitiator(String email, int size, int page, String sortAttr,
			String order) {
		Direction direction = order.equals(Direction.ASC.toString()) ? Direction.ASC : Direction.DESC;
		return this.groupDao.findAllByGroupInitiator_Email(email,PageRequest.of(page,size,direction, sortAttr)).stream()
				.map(this.converter::group_EntityToBoundary).collect(Collectors.toList());
	}

	@Override
	public List<GroupBoundary> getAllPostsByMinNumOfMembers(String numOfMembers, int size, int page, String sortAttr,
			String order) {
		Direction direction = order.equals(Direction.ASC.toString()) ? Direction.ASC : Direction.DESC;
		return this.groupDao.findAllByNumOfMembersGreaterThanEqual(Integer.parseInt(numOfMembers),PageRequest.of(page,size,direction, sortAttr)).stream()
				.map(this.converter::group_EntityToBoundary).collect(Collectors.toList());
	}

	@Override
	public List<GroupBoundary> getAllPostsByMaxNumOfMembers(String numOfMembers, int size, int page, String sortAttr,
			String order) {
		Direction direction = order.equals(Direction.ASC.toString()) ? Direction.ASC : Direction.DESC;
		return this.groupDao.findAllByNumOfMembersLessThanEqual(Integer.parseInt(numOfMembers),PageRequest.of(page,size,direction, sortAttr)).stream()
				.map(this.converter::group_EntityToBoundary).collect(Collectors.toList());
	}

	@Override
	public List<GroupBoundary> getAllPostsByMinDiscount(String discount, int size, int page, String sortAttr,
			String order) {
		Direction direction = order.equals(Direction.ASC.toString()) ? Direction.ASC : Direction.DESC;
		return this.groupDao.findAllByDiscountGreaterThanEqual(Double.parseDouble(discount),PageRequest.of(page,size,direction, sortAttr)).stream()
				.map(this.converter::group_EntityToBoundary).collect(Collectors.toList());
	}

	@Override
	public List<GroupBoundary> getAllPostsByCreationTime(String stringDate, int size, int page, String sortAttr,
			String order) {
		Date date = this.validator.validDate(stringDate);
		Direction direction = order.equals(Direction.ASC.toString()) ? Direction.ASC : Direction.DESC;
		return this.groupDao.findAllByDateOpenedGreaterThanEqual(date,PageRequest.of(page,size,direction, sortAttr)).stream()
				.map(this.converter::group_EntityToBoundary).collect(Collectors.toList());
	}	

}
