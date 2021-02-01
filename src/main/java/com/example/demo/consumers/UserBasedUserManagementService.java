package com.example.demo.consumers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.boundaries.User;
import com.example.demo.exceptions.InvalidEmailException;

@Component
public class UserBasedUserManagementService {
	
	private RestTemplate restTemplate;
	private String url;
	private String host; 
	private int port;
	
	
	@Value("${userManagementService.port:8080}")
	public void setPort(String port) {
		this.port = Integer.parseInt(port);
	}
	
	@Value("${userManagementService.host:localhost}")
	public void setHost(String host) {
		this.host = host;
	}


	@PostConstruct
	public void init() {
		this.restTemplate = new RestTemplate();
		
		this.url = "http://" + host + ":" + port;
	}
	
	
	public void getUserFromUserManagement(String email) {
		ResponseEntity<User> user;
		try {
			user = restTemplate.getForEntity(this.url + "/users/{email}", User.class, email);
		} catch (Exception e) {
			throw new InvalidEmailException("Email does not exist in the system");
		}
	
		if(user.getStatusCode() != HttpStatus.OK || user.getBody() == null) {
			throw new InvalidEmailException("Email does not exist in the system");
		}


	}

}
