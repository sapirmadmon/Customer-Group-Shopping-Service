package com.example.demo.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.boundaries.GroupBoundary;
import com.example.demo.boundaries.Product;
import com.example.demo.boundaries.User;
import com.example.demo.data.GroupEntity;


@Component
public class GroupConverter {
	// group boundary -> entity
	public GroupEntity group_BoundarytoEntity(GroupBoundary boundary) {
		GroupEntity entity = new GroupEntity();
		entity.setGroupId(boundary.getGroupId());
		entity.setGroupInitiator(user_BoundaryToEntity(boundary.getGroupInitiator()));
		entity.setNumOfMembers(boundary.getNumOfMembers());
		entity.setMembers(boundary.getMembers().stream().map(this::user_BoundaryToEntity).collect(Collectors.toList()));
		entity.setProduct(product_BoundaryToEntity(boundary.getProduct()));
		entity.setProdQuantity(boundary.getProdQuantity());
		entity.setDiscount(boundary.getDiscount());
		entity.setDateOpened(boundary.getDateOpened());
		entity.setValidity(boundary.getValidity());
		entity.setExtras(boundary.getExtras());
		return entity;
	}
	
	// group entity -> boundary
	public GroupBoundary group_EntityToBoundary(GroupEntity entity) {
		GroupBoundary boundary = new GroupBoundary();
		boundary.setGroupId(entity.getGroupId());
		boundary.setGroupInitiator(user_EntityToBoundary(entity.getGroupInitiator()));
		boundary.setNumOfMembers(entity.getNumOfMembers());
		boundary.setMembers(entity.getMembers().stream().map(this::user_EntityToBoundary).collect(Collectors.toList()));
		boundary.setProduct(product_EntityToBoundary(entity.getProduct()));
		boundary.setProdQuantity(entity.getProdQuantity());
		boundary.setDiscount(entity.getDiscount());
		boundary.setDateOpened(entity.getDateOpened());
		boundary.setValidity(entity.getValidity());
		boundary.setExtras(entity.getExtras());
		return boundary;
	}
	
	// product boundary -> entity
	public Product product_BoundaryToEntity(Product boundary) {
		Product entity = new Product();
		entity.setProductId(boundary.getProductId());
		//entity.setId(boundary.getProductId());
		return entity;
	}
	
	// product entity -> boundary
	public Product product_EntityToBoundary(Product entity) {
		Product boundary = new Product();
		boundary.setProductId(entity.getProductId());
		//boundary.setProductId(entity.getId());
		return boundary;
	}
	
	// user boundary -> entity
	public User user_BoundaryToEntity(User boundary) {
		User entity = new User();
		entity.setEmail(boundary.getEmail());
		return entity;
	}
	
	// user entity -> boundary
	public User user_EntityToBoundary(User entity) {
		User boundary = new User();
		boundary.setEmail(entity.getEmail());
		return boundary;
	}
}
