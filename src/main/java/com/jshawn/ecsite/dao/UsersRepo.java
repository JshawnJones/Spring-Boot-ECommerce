package com.jshawn.ecsite.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jshawn.ecsite.model.Users;

public interface UsersRepo extends CrudRepository<Users, Long>{

	List<Users> findByUsername(String name);
}
