package com.jshawn.ecsite.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshawn.ecsite.dao.UsersRepo;
import com.jshawn.ecsite.model.Users;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{
	
	private UsersRepo usersrepo;

	public UsersServiceImpl(UsersRepo usersrepo) {
		this.usersrepo = usersrepo;
	}

	@Override
	public Iterable<Users> getAllUsers() {
		return usersrepo.findAll();
	}

	@Override
	public Users create(Users users) {
		users.setReg_date(LocalDate.now());
		
		return this.usersrepo.save(users);
	}

	@Override
	public Users getUsersById(@Min(value = 1, message = "Invalid Users ID.") Long id) {
		
		return usersrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}

	@Override
	public Users save(Users user) {
		
		return usersrepo.save(user);
	}

	@Override
	public List<Users> findByUsername(String name) {
		
		return usersrepo.findByUsername(name);
	}

	@Override
	public Iterable<Users> findAll() {
		
		return usersrepo.findAll();
	}
	
	
	
}
