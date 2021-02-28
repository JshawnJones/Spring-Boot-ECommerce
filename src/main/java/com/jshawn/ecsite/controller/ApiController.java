package com.jshawn.ecsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jshawn.ecsite.model.Cart;
import com.jshawn.ecsite.model.CartJson;
import com.jshawn.ecsite.model.CartLineItem;
import com.jshawn.ecsite.model.PaymentJson;
import com.jshawn.ecsite.model.Product;
import com.jshawn.ecsite.model.Users;
import com.jshawn.ecsite.service.CartLineItemService;
import com.jshawn.ecsite.service.CartService;
import com.jshawn.ecsite.service.UserDetailsService;
import com.jshawn.ecsite.service.UsersService;

@RestController
@RequestMapping(path="/api")
public class ApiController {

	private UsersService usersService;
	private UserDetailsService userDetailsService;
	private CartService cartService;
	private CartLineItemService cartLineItemService;
	
	@Autowired
	public ApiController(
			UsersService usersService, 
			UserDetailsService userDetailsService,
			CartService cartService,
			CartLineItemService cartLineItemService) {
		
		this.usersService = usersService;
		this.userDetailsService = userDetailsService;
		this.cartService = cartService;
		this.cartLineItemService = cartLineItemService;
	}
	
	
	@PostMapping(value = {"/cart/save"})
	public void saveCart(@RequestParam("cart") String cart, 
			@RequestParam("totalprice") Double totalprice) throws JsonMappingException, JsonProcessingException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		
		if(auth.getPrincipal() instanceof java.lang.String) {
			
			username = (String) auth.getPrincipal();
			
		} else if (auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			
			username = userDetails.getUsername();
		}

		//check if cart exists
		List<Users> currentUser = usersService.findByUsername(username);
		
		Long userId = currentUser.get(0).getId();
		List<Cart> checkExistingCart = cartService.getByUserId(userId);
		if(checkExistingCart.size() > 0) {
			
			Cart existingCart = checkExistingCart.get(0);
			Long cartId = existingCart.getId();
			
			
			List<CartLineItem> cartLineList = cartLineItemService.getByCartId(cartId);
			
			for(CartLineItem item : cartLineList) {
				
				cartLineItemService.deleteLinesById(item.getCart_id());
			}
			
			addNewCartLines(cart, existingCart);
			
			existingCart.setTotal_price(totalprice);
			cartService.update(existingCart);
		} else {
			//create new cart in db
			Cart cartDBObj = new Cart();
			cartDBObj.setUser_id(userId);
			cartDBObj.setTotal_price(totalprice);
			
			Cart savedCart = cartService.create(cartDBObj);
			
			addNewCartLines(cart, savedCart);
			
		}
		
	}
	
	@PostMapping(value = {"/order/save"})
	public void checkout(@RequestParam("paymentDetails") String paymentDetails) throws JsonMappingException, JsonProcessingException {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		
		if(auth.getPrincipal() instanceof java.lang.String) {
			
			username = (String) auth.getPrincipal();
			
		} else if (auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			
			username = userDetails.getUsername();
		}
		
		Long userId = usersService.findByUsername(username).get(0).getId();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); 
		PaymentJson userDetailsList = mapper.readValue(paymentDetails, new TypeReference<PaymentJson>(){});
		
		
		com.jshawn.ecsite.model.UserDetails userDetails = userDetailsService.getUserDetailsByUserId(userId);
		if(userDetails == null) {
			userDetails = new com.jshawn.ecsite.model.UserDetails(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		}
		
		userDetails.setUserid(userId);
		userDetails.setFirst_name(userDetailsList.getShippingAddress().getFirst_name());
		userDetails.setLast_name(userDetailsList.getShippingAddress().getLast_name());
		userDetails.setShipping_address_1(userDetailsList.getShippingAddress().getShipping_address_1());
		userDetails.setShipping_address_2(userDetailsList.getShippingAddress().getShipping_address_2());
		userDetails.setShipping_postcode(userDetailsList.getShippingAddress().getShipping_postcode());
		userDetails.setShipping_city(userDetailsList.getShippingAddress().getShipping_city());
		userDetails.setShipping_state(userDetailsList.getShippingAddress().getShipping_state());
		userDetails.setShipping_country(userDetailsList.getShippingAddress().getShipping_country());
		userDetails.setShipping_phone(userDetailsList.getShippingAddress().getShipping_phone());
		userDetails.setBilling_first_name(userDetailsList.getBillingAddress().getBilling_first_name());
		userDetails.setBilling_last_name(userDetailsList.getBillingAddress().getBilling_last_name());
		userDetails.setBilling_address_1(userDetailsList.getBillingAddress().getBilling_address_1());
		userDetails.setBilling_address_2(userDetailsList.getBillingAddress().getBilling_address_2());
		userDetails.setBilling_postcode(userDetailsList.getBillingAddress().getBilling_postcode());
		userDetails.setBilling_city(userDetailsList.getBillingAddress().getBilling_city());
		userDetails.setBilling_state(userDetailsList.getBillingAddress().getBilling_state());
		userDetails.setBilling_country(userDetailsList.getBillingAddress().getBilling_country());
		userDetails.setBilling_phone(userDetailsList.getBillingAddress().getBilling_phone());
		userDetails.setCard_number(userDetailsList.getPaymentInfo().getCard_number());
		userDetails.setCard_name(userDetailsList.getPaymentInfo().getCard_name());
		userDetails.setCard_exp_date(userDetailsList.getPaymentInfo().getCard_exp_date());
		
		
		userDetailsService.save(userDetails);
		
	}
	
	
	public void addNewCartLines(String cart, Cart savedCart) throws JsonMappingException, JsonProcessingException {
		//create cart line items in db
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); 
		List<CartJson> cartList = mapper.readValue(cart, new TypeReference<List<CartJson>>(){});


		for(CartJson cartLineItem : cartList) {
			
			Product product = cartLineItem.getProduct();
			int quantity = cartLineItem.getQuantity();
			
			CartLineItem cartLine = new CartLineItem();
			cartLine.setCart_id(savedCart.getId());
			cartLine.setProduct_id(product.getId());
			cartLine.setQuantity(quantity);
			cartLine.setLine_price(product.getPrice() * quantity);
			
			cartLineItemService.create(cartLine);
		}
	}
	
	
}
