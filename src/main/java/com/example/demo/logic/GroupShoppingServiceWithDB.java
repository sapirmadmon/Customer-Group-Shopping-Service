package com.example.demo.logic;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.boundaries.GroupBoundary;
import com.example.demo.converters.GroupConverter;
import com.example.demo.dal.GroupDao;
import com.example.demo.data.GroupEntity;
import com.example.demo.exceptions.EmptyProductException;
import com.example.demo.exceptions.InvalidEmailException;
import com.example.demo.validator.Validator;

@Service
public class GroupShoppingServiceWithDB implements GroupShoppingService{
	private GroupDao groupDao;
	private GroupConverter converter;
	private Validator validator;
	
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

	@Override
	public GroupBoundary createGroup(GroupBoundary group) {
		
		//Check if the email is OK
		if (!this.validator.validateUserEmail(group.getGroupInitiator().getEmail())) {
			throw new InvalidEmailException("Email must be in the format of example@example.com");
		} 
		
		//Check if the product ID is not null
		if(group.getProduct().getProductId() == null) {
			throw new EmptyProductException("The product ID is empty");
		}
		
		//TODO more check 
		
		group.setDateOpened(new Date());
		group.setGroupId(UUID.randomUUID().toString()); 
		
		GroupEntity savedGroup = this.groupDao.save(this.converter.group_BoundarytoEntity(group));
		
		return this.converter.group_EntityToBoundary(savedGroup);
	}

	@Override
	public List<GroupBoundary> getAllGroups(int size, int page, String sortAttr, String order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
