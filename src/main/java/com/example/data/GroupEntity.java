package com.example.data;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "groups")
public class GroupEntity {
	
	@Id private Long groupId;
	private UserEntity groupInitiator;
	private int numOfMembers;
	private List<UserEntity> members;
	private ProductEntity product;
	private int prodQuantity;
	private double discount;
	private Date dateOpened;
	private int validity;
	private Map<String, Object> extras;
	
	public GroupEntity() {
		super();
	}

	public GroupEntity(Long groupId, UserEntity groupInitiator, int numOfMembers, List<UserEntity> members,
			ProductEntity product, int prodQuantity, double discount, Date dateOpened, int validity,
			Map<String, Object> extras) {
		super();
		this.groupId = groupId;
		this.groupInitiator = groupInitiator;
		this.numOfMembers = numOfMembers;
		this.members = members;
		this.product = product;
		this.prodQuantity = prodQuantity;
		this.discount = discount;
		this.dateOpened = dateOpened;
		this.validity = validity;
		this.extras = extras;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public UserEntity getGroupInitiator() {
		return groupInitiator;
	}

	public void setGroupInitiator(UserEntity groupInitiator) {
		this.groupInitiator = groupInitiator;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}

	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	public List<UserEntity> getMembers() {
		return members;
	}

	public void setMembers(List<UserEntity> members) {
		this.members = members;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public Map<String, Object> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, Object> extras) {
		this.extras = extras;
	}
	
	
}
