package com.jshawn.ecsite.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.jshawn.ecsite.model.OrderLineItem;

@Validated
public interface OrderLineItemService {

	OrderLineItem create(@NotNull(message = "The products for order cannot be null.") @Valid OrderLineItem orderLineItem);
}
