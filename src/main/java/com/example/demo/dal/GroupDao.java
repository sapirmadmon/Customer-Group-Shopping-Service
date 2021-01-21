package com.example.demo.dal;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.data.GroupEntity;

public interface GroupDao extends PagingAndSortingRepository<GroupEntity, String>{

	public List<GroupEntity> findAllByGroupInitiator_Email(@Param("filterValue")String email, Pageable pageable);
	public List<GroupEntity> findAllByNumOfMembersGreaterThanEqual(@Param("filterValue")int numOfMembers, Pageable opageablef);
	public List<GroupEntity> findAllByNumOfMembersLessThanEqual(@Param("filterValue")int numOfMembers, Pageable pageable);
	public List<GroupEntity> findAllByDiscountGreaterThanEqual(@Param("filterValue")double discount, Pageable pageable);
	public List<GroupEntity> findAllByDateOpenedGreaterThanEqual(@Param("filterValue")Date date, Pageable pageable);
}
