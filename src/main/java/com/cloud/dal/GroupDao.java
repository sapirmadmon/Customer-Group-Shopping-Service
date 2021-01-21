package com.cloud.dal;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloud.data.GroupEntity;

public interface GroupDao extends PagingAndSortingRepository<GroupEntity, Long>{
	
}
