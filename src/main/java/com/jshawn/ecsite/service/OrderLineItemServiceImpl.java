package com.jshawn.ecsite.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshawn.ecsite.dao.OrderLineItemRepo;
import com.jshawn.ecsite.model.OrderLineItem;

@Service
@Transactional
public class OrderLineItemServiceImpl implements OrderLineItemService{

	private OrderLineItemRepo orderLineItemRepo;

	public OrderLineItemServiceImpl(OrderLineItemRepo orderLineItemRepo) {
		this.orderLineItemRepo = orderLineItemRepo;
	}

	@Override
	public OrderLineItem create( OrderLineItem orderLineItem) {
		
		return this.orderLineItemRepo.save(orderLineItem);
	}

	
}
