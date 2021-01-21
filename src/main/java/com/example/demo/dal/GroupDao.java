package com.example.demo.dal;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.data.GroupEntity;

public interface GroupDao extends PagingAndSortingRepository<GroupEntity, String>{
	
}
