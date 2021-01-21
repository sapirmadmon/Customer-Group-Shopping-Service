package com.example.demo.logic;

import java.util.List;

import com.example.demo.boundaries.GroupBoundary;

public interface GroupShoppingService {

	public GroupBoundary createGroup(GroupBoundary group);

	public List<GroupBoundary> getAllGroups(int size, int page, String sortAttr, String order);

	public void updateGroup(String groupId, GroupBoundary group);

	public void deleteAll();

	public List<GroupBoundary> getAllPostsByInitiator(String filterValue, int size, int page, String sortAttr,
			String order);

	public List<GroupBoundary> getAllPostsByMinNumOfMembers(String filterValue, int size, int page, String sortAttr,
			String order);

	public List<GroupBoundary> getAllPostsByMaxNumOfMembers(String filterValue, int size, int page, String sortAttr, String order);

	public List<GroupBoundary> getAllPostsByMinDiscount(String filterValue, int size, int page, String sortAttr,
			String order);
	
	public List<GroupBoundary> getAllPostsByCreationTime(String filterValue, int size, int page, String sortAttr,
			String order);
}
