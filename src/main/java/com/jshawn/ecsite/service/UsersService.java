package com.jshawn.ecsite.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.jshawn.ecsite.model.Users;

@Validated
public interface UsersService {

	@NotNull Iterable<Users> getAllUsers();
	
	Users create(@NotNull(message = "The user cannot be null.") @Valid Users users);
	
	Users getUsersById(@Min(value = 1L, message = "Invalid Users ID.") Long id);
	
	Users save(Users user);
	
	List<Users> findByUsername(String name);
	
	Iterable<Users> findAll();
}
