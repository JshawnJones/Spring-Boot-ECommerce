package com.jshawn.ecsite.service;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.jshawn.ecsite.model.UserDetails;

@Validated
public interface UserDetailsService {

	UserDetails save(UserDetails userDetails);
	
	UserDetails getUserDetailsByUserId(@Min(value = 1L, message = "Invalid Users ID.") Long id);
}
