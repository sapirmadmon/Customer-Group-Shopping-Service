package com.example.demo.logic;

import java.util.List;

import com.example.demo.boundaries.GroupBoundary;

public interface GroupShoppingService {

	public GroupBoundary createGroup(GroupBoundary group);

	public List<GroupBoundary> getAllGroups(int size, int page, String sortAttr, String order);

}
