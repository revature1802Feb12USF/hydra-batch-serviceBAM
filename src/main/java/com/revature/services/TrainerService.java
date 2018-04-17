package com.revature.services;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.beans.BamUser;

@Service
public class TrainerService {
	
	@LoadBalanced
	@Bean
	public RestTemplate buildRestTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	} 
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TrainerService() {
		super();
	}
	
	public TrainerService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@HystrixCommand(fallbackMethod="cachedGetTrainerByEmail")
	public Integer getTrainerByEmail(String email) {
		BamUser returner = restTemplate.getForObject("http://hydra-user-service/byEmail/" + email + "/", BamUser.class);
		if(returner == null)
			return null;
		cache.put(email, returner.getUserId());
		return returner.getUserId();
	}
	
	
	Hashtable<String, Integer> cache = new Hashtable<String, Integer> ();
	
	public Integer cachedGetTrainerByEmail(String email) {
		return cache.get(email);
	}

	public void testingAddToCache(String email, Integer trainerID) {
		cache.put(email, trainerID);
	}
}
