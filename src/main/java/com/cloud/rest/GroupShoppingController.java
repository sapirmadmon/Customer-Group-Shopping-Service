package com.cloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.logic.GroupShoppingService;

@RestController
public class GroupShoppingController {
	private GroupShoppingService groupShoppingService;

	@Autowired
	public GroupShoppingController(GroupShoppingService groupShoppingService) {
		this.groupShoppingService = groupShoppingService;
	}
	
	
}
