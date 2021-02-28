package com.jshawn.ecsite.dao;

import org.springframework.data.repository.CrudRepository;

import com.jshawn.ecsite.model.OrderLineItem;

public interface OrderLineItemRepo extends CrudRepository<OrderLineItem, Long>{

}
