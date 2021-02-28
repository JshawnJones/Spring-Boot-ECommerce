package com.jshawn.ecsite.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jshawn.ecsite.dao.OrderRepo;
import com.jshawn.ecsite.model.Order;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	private OrderRepo orderRepo;

	public OrderServiceImpl(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;
	}

	@Override
	public Iterable<Order> getAllOrders() {
		
		return this.orderRepo.findAll();
	}

	@Override
	public Order create(Order order) {
		order.setCreated_date(LocalDate.now());
		
		return this.orderRepo.save(order);
	}

	@Override
	public void update(Order order) {
		this.orderRepo.save(order);
		
	}
	
	
}
