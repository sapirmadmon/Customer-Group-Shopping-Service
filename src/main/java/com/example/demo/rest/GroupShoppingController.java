package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.boundaries.GroupBoundary;
import com.example.demo.logic.GroupShoppingService;
import com.example.demo.utility.ControllerTypes;

@RestController
public class GroupShoppingController {
	
	private GroupShoppingService groupShoppingService;

	@Autowired
	public GroupShoppingController(GroupShoppingService groupShoppingService) {
		this.groupShoppingService = groupShoppingService;
	}
	
	
	@RequestMapping(path = "/groups", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public GroupBoundary createGroup(@RequestBody GroupBoundary group) {
		return this.groupShoppingService.createGroup(group);
	}
	

	
	@RequestMapping(path = "/groups",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public GroupBoundary[] getAllGroups(
		@RequestParam(name = "filterType", required = false, defaultValue = "") String filterType,
		@RequestParam(name = "filterValue", required = false) String filterValue,
		@RequestParam(name = "sortBy", required = false, defaultValue = "dateOpened") String sortAttr,
		@RequestParam(name = "sortOrder", required = false, defaultValue = "ASC") String order,
		@RequestParam(name = "page", required = false, defaultValue = "0") int page,
		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
			
		switch(filterType) {
			
			case ControllerTypes.BY_INITIATOR:
				return this.groupShoppingService.getAllPostsByInitiator(filterValue, size, page, sortAttr, order)
				.toArray(new GroupBoundary[0]);
			
			case ControllerTypes.BY_MIN_NUM_OF_MEMBERS:
				return this.groupShoppingService.getAllPostsByMinNumOfMembers(filterValue, size, page, sortAttr, order)
				.toArray(new GroupBoundary[0]);
			
			case ControllerTypes.BY_MAX_NUM_OF_MEMBERS:
				return this.groupShoppingService.getAllPostsByMaxNumOfMembers(filterValue, size, page, sortAttr, order)
				.toArray(new GroupBoundary[0]);
			
			case ControllerTypes.BY_DISCOUNT:
				return this.groupShoppingService.getAllPostsByMinDiscount(filterValue, size, page, sortAttr, order)
				.toArray(new GroupBoundary[0]);
			
			case ControllerTypes.BY_CREATION_TIME:
				return this.groupShoppingService.getAllPostsByCreationTime(filterValue, size, page, sortAttr, order)
				.toArray(new GroupBoundary[0]);
			
			default:
				return this.groupShoppingService.getAllGroups(size, page, sortAttr, order)
						.toArray(new GroupBoundary[0]);
			
		}
		
	}
	
	
	@RequestMapping(
			path = "/groups/{groupId}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateGroup(@RequestBody GroupBoundary group, @PathVariable("groupId") String groupId) {
		this.groupShoppingService.updateGroup(groupId, group);
	}
	
	
	@RequestMapping(
			path = "/groups",
			method = RequestMethod.DELETE)
	public void deleteAllGroup() {
		this.groupShoppingService.deleteAll();
	}
	
	
}
