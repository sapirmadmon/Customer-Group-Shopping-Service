package com.example.demo.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.boundaries.GroupBoundary;
import com.example.demo.boundaries.ProductBoundary;
import com.example.demo.boundaries.UserBoundary;
import com.example.demo.data.GroupEntity;
import com.example.demo.data.ProductEntity;
import com.example.demo.data.UserEntity;

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
	public ProductEntity product_BoundaryToEntity(ProductBoundary boundary) {
		ProductEntity entity = new ProductEntity();
		entity.setId(boundary.getProductId());
		return entity;
	}
	
	// product entity -> boundary
	public ProductBoundary product_EntityToBoundary(ProductEntity entity) {
		ProductBoundary boundary = new ProductBoundary();
		boundary.setProductId(entity.getId());
		return boundary;
	}
	
	// user boundary -> entity
	public UserEntity user_BoundaryToEntity(UserBoundary boundary) {
		UserEntity entity = new UserEntity();
		entity.setEmail(boundary.getEmail());
		return entity;
	}
	
	// user entity -> boundary
	public UserBoundary user_EntityToBoundary(UserEntity entity) {
		UserBoundary boundary = new UserBoundary();
		boundary.setEmail(entity.getEmail());
		return boundary;
	}
}
