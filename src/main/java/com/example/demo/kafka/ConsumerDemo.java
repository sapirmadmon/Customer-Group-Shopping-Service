package com.example.demo.kafka;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.boundaries.GroupBoundary;

import com.example.demo.logic.GroupShoppingServiceWithDB;

@Configuration
public class ConsumerDemo {
	
	private GroupShoppingServiceWithDB groupShoppingImp;
	
	@Autowired
	public ConsumerDemo(GroupShoppingServiceWithDB groupShoppingImp) {
		this.groupShoppingImp = groupShoppingImp;
	}


	@Bean
	public Consumer<GroupBoundary> receiveAndHandleRemoteNewGroup() {
		
		//return group -> System.err.println(group);
		return group->this.groupShoppingImp.createGroup(group);
	}

}
