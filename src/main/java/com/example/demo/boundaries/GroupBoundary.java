package com.example.demo.boundaries;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class GroupBoundary {
	private String groupId;
	private UserBoundary groupInitiator;
	private int numOfMembers;
	private List<UserBoundary> members;
	private ProductBoundary product;
	private int prodQuantity;
	private double discount;
	private Date dateOpened;
	private int validity;
	private Map<String, Object> extras;
	
	public GroupBoundary() {
		super();
	}

	public GroupBoundary(String groupId, UserBoundary groupInitiator, int numOfMembers, List<UserBoundary> members,
			ProductBoundary product, int prodQuantity, double discount, Date dateOpened, int validity,
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public UserBoundary getGroupInitiator() {
		return groupInitiator;
	}

	public void setGroupInitiator(UserBoundary groupInitiator) {
		this.groupInitiator = groupInitiator;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}

	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	public List<UserBoundary> getMembers() {
		return members;
	}

	public void setMembers(List<UserBoundary> members) {
		this.members = members;
	}

	public ProductBoundary getProduct() {
		return product;
	}

	public void setProduct(ProductBoundary product) {
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
