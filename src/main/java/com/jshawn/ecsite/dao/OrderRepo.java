package com.jshawn.ecsite.dao;

import org.springframework.data.repository.CrudRepository;

import com.jshawn.ecsite.model.Order;

public interface OrderRepo extends CrudRepository<Order, Long>{

}
