package com.cloud.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloud.converters.GroupConverter;
import com.cloud.dal.GroupDao;
import com.cloud.validator.Validator;

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
	
	
	
}
