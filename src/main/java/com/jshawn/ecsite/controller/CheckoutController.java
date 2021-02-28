package com.jshawn.ecsite.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jshawn.ecsite.model.Cart;
import com.jshawn.ecsite.model.CartLineItem;
import com.jshawn.ecsite.model.Order;
import com.jshawn.ecsite.model.OrderLineItem;
import com.jshawn.ecsite.model.PaymentStatus;
import com.jshawn.ecsite.model.Product;
import com.jshawn.ecsite.model.ShipmentStatus;
import com.jshawn.ecsite.model.Users;
import com.jshawn.ecsite.service.CartLineItemService;
import com.jshawn.ecsite.service.CartService;
import com.jshawn.ecsite.service.OrderLineItemService;
import com.jshawn.ecsite.service.OrderService;
import com.jshawn.ecsite.service.ProductService;
import com.jshawn.ecsite.service.UserDetailsService;
import com.jshawn.ecsite.service.UsersService;

@Controller
public class CheckoutController {

	private ProductService productService;
	private UsersService usersService;
	private UserDetailsService userDetailsService;
	private CartService cartService;
	private CartLineItemService cartLineItemService;
	private OrderService orderService;
	private OrderLineItemService orderLineItemService;
	
	@Autowired
	public CheckoutController(ProductService productService, 
			UsersService usersService, 
			UserDetailsService userDetailsService,
			CartService cartService,
			CartLineItemService cartLineItemService,
			OrderService orderService,
			OrderLineItemService orderLineItemService) {
		this.productService = productService;
		this.usersService = usersService;
		this.userDetailsService = userDetailsService;
		this.cartService = cartService;
		this.cartLineItemService = cartLineItemService;
		this.orderService = orderService;
		this.orderLineItemService = orderLineItemService;
	}
	
	@GetMapping(value = {"/checkout"})
	public  ModelAndView checkout() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		
		if(auth.getPrincipal() instanceof java.lang.String) {
			
			username = (String) auth.getPrincipal();
			
		} else if (auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			
			username = userDetails.getUsername();
		}
		
		String role = "";
		String name = "";
		ModelAndView modelAndView = new ModelAndView();
		
		List<Users> user = usersService.findByUsername(username);
		
		if(user.size() > 0) {
			role = user.get(0).getRole();
			name = user.get(0).getUsername();
		}
		
		Long userId = user.get(0).getId();
		List<Cart> checkExistingCart = cartService.getByUserId(userId);
		if(checkExistingCart.size() > 0) {
			Cart existingCart = checkExistingCart.get(0);
			Long cartId = existingCart.getId();
			
			
			List<CartLineItem> cartLineList = cartLineItemService.getByCartId(cartId);
			
			List<Product> existingCartProducts = new ArrayList<Product>();
			
			for(CartLineItem item : cartLineList) {
				Product cartLineProduct = productService.getProductById(item.getProduct_id());
				cartLineProduct.setInventory(item.getQuantity());
				existingCartProducts.add(cartLineProduct);
			}
			
			
			modelAndView.addObject("cartTotalPrice", existingCart.getTotal_price());
			modelAndView.addObject("existingCart", existingCartProducts);
		}

		modelAndView.addObject("role", role);
		modelAndView.addObject("name", name);
		modelAndView.setViewName("/checkout");
		return modelAndView;
	}
	
	@GetMapping(value = {"/payment"})
	public  ModelAndView payment() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		
		if(auth.getPrincipal() instanceof java.lang.String) {
			
			username = (String) auth.getPrincipal();
			
		} else if (auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			
			username = userDetails.getUsername();
		}
		
		String role = "";
		String name = "";
		
		if(usersService.findByUsername(username).size() > 0) {
			role = usersService.findByUsername(username).get(0).getRole();
			name = usersService.findByUsername(username).get(0).getUsername();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		
		//get user details
		List<Users> currentUser = usersService.findByUsername(username);
		Long userId = currentUser.get(0).getId();
		
		com.jshawn.ecsite.model.UserDetails userDetails = userDetailsService.getUserDetailsByUserId(userId);
		if(userDetails == null) {
			com.jshawn.ecsite.model.UserDetails blankdetails = new com.jshawn.ecsite.model.UserDetails(userId, userId, name, name, name, name, name, name, name, name, name, name, name, name, name, name, name, name, name, name, null, name, null);
			
			modelAndView.addObject("userdetails", blankdetails);
		} else {
			modelAndView.addObject("userdetails", userDetails);
		}
		
		
		modelAndView.addObject("role", role);
		modelAndView.addObject("name", name);
		
		
		return modelAndView;
	}
	
	@GetMapping(value = {"/review"})
	public  ModelAndView review() {
		ModelAndView modelAndView = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		
		if(auth.getPrincipal() instanceof java.lang.String) {
			
			username = (String) auth.getPrincipal();
			
		} else if (auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			
			username = userDetails.getUsername();
		}
		
		String role = "";
		String name = "";
		List<Users> user = usersService.findByUsername(username);
		if(user.size() > 0) {
			role = user.get(0).getRole();
			name = user.get(0).getUsername();
		}
		
		Long userId = user.get(0).getId();
		List<Cart> checkExistingCart = cartService.getByUserId(userId);
		if(checkExistingCart.size() > 0) {
			Cart existingCart = checkExistingCart.get(0);
			Long cartId = existingCart.getId();
			
			
			List<CartLineItem> cartLineList = cartLineItemService.getByCartId(cartId);
			
			List<Product> existingCartProducts = new ArrayList<Product>();
			
			for(CartLineItem item : cartLineList) {
				Product cartLineProduct = productService.getProductById(item.getProduct_id());
				cartLineProduct.setInventory(item.getQuantity());
				existingCartProducts.add(cartLineProduct);
			}
			
			
			modelAndView.addObject("cartTotalPrice", existingCart.getTotal_price());
			modelAndView.addObject("existingCart", existingCartProducts);
		}
		
		com.jshawn.ecsite.model.UserDetails userDetails = userDetailsService.getUserDetailsByUserId(userId);
		modelAndView.addObject("userdetails", userDetails);
		
		modelAndView.addObject("role", role);
		modelAndView.addObject("name", name);
		return modelAndView;
	}
	
	@GetMapping(value = {"/confirmation"})
	public  ModelAndView confirmation() {
		ModelAndView modelAndView = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		
		if(auth.getPrincipal() instanceof java.lang.String) {
			
			username = (String) auth.getPrincipal();
			
		} else if (auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			
			username = userDetails.getUsername();
		}
		
		String role = "";
		String name = "";
		List<Users> user = usersService.findByUsername(username);
		if(user.size() > 0) {
			role = user.get(0).getRole();
			name = user.get(0).getUsername();
		}
		Long userId = user.get(0).getId();
		
		List<Cart> checkExistingCart = cartService.getByUserId(userId);
		Cart cart = checkExistingCart.get(0);
		
		//create and save order
		Order order = new Order();
		order.setUser_id(userId);
		
		Long userDetailsId = userDetailsService.getUserDetailsByUserId(userId).getId();
		order.setUser_details_id(userDetailsId);
		
		LocalDate now = LocalDate.now();
		order.setCreated_date(now);
		order.setModified_date(now);
		order.setPayment_status(PaymentStatus.PENDING.name());
		order.setShipment_status(ShipmentStatus.PENDING.name());
		order.setTotal_price(cart.getTotal_price());
		Order createdOrder = orderService.create(order);
		
		//create and save each order line
		List<CartLineItem> cartLineList = cartLineItemService.getByCartId(cart.getId());
		for(CartLineItem item : cartLineList) {
			OrderLineItem orderLineItem = new OrderLineItem();
			
			orderLineItem.setOrder_id(createdOrder.getId());
			orderLineItem.setProduct_id(item.getProduct_id());
			orderLineItem.setQuantity(item.getQuantity());
			orderLineItem.setLine_price(item.getLine_price());
			
			orderLineItemService.create(orderLineItem);
			
			cartLineItemService.deleteById(item.getId());
		}
		
		cartService.deleteById(cart.getId());
		
		modelAndView.addObject("role", role);
		modelAndView.addObject("name", name);
		return modelAndView;
	}
	
}
