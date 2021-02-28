package com.jshawn.ecsite.dao;


import org.springframework.data.repository.CrudRepository;

import com.jshawn.ecsite.model.UserDetails;

public interface UserDetailsRepo extends CrudRepository<UserDetails, Long>{

	UserDetails findByUserid(Long id);
}
