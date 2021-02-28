package com.jshawn.ecsite.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshawn.ecsite.dao.UserDetailsRepo;
import com.jshawn.ecsite.model.UserDetails;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

	private UserDetailsRepo userDetailsRepo;

	public UserDetailsServiceImpl(UserDetailsRepo userDetailsRepo) {
		this.userDetailsRepo = userDetailsRepo;
		
	}

	@Override
	public UserDetails save(UserDetails userDetails) {
		
		return userDetailsRepo.save(userDetails);
	}

	@Override
	public UserDetails getUserDetailsByUserId(Long id) {
		
		return userDetailsRepo.findByUserid(id);
	}
	
	
}
