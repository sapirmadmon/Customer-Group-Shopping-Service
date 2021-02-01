package com.example.demo.boundaries;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class GroupBoundary {
	private String groupId;
	private User groupInitiator;
	private int numOfMembers;
	private List<User> members;
	private Product product;
	private int prodQuantity;
	private double discount;
	private Date dateOpened;
	private int validity;
	private Map<String, Object> extras;
	
	public GroupBoundary() {
		super();
	}

	public GroupBoundary(String groupId, User groupInitiator, int numOfMembers, List<User> members,
			Product product, int prodQuantity, double discount, Date dateOpened, int validity,
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

	public User getGroupInitiator() {
		return groupInitiator;
	}

	public void setGroupInitiator(User groupInitiator) {
		this.groupInitiator = groupInitiator;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}

	public void setNumOfMembers(int numOfMembers) {
		this.numOfMembers = numOfMembers;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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

	@Override
	public String toString() {
		return "GroupBoundary [groupId=" + groupId + ", groupInitiator=" + groupInitiator + ", numOfMembers="
				+ numOfMembers + ", members=" + members + ", product=" + product + ", prodQuantity=" + prodQuantity
				+ ", discount=" + discount + ", dateOpened=" + dateOpened + ", validity=" + validity + ", extras="
				+ extras + "]";
	}


	
	
}
