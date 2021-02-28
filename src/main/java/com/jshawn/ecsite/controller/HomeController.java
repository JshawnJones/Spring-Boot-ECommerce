package com.jshawn.ecsite.controller;

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
import com.jshawn.ecsite.model.Product;
import com.jshawn.ecsite.model.Users;
import com.jshawn.ecsite.service.CartLineItemService;
import com.jshawn.ecsite.service.CartService;
import com.jshawn.ecsite.service.ProductService;
import com.jshawn.ecsite.service.UsersService;

@Controller
public class HomeController {

	private ProductService productService;
	private UsersService usersService;
	private CartService cartService;
	private CartLineItemService cartLineItemService;
	
	@Autowired
	public HomeController(ProductService productService, 
			UsersService usersService,
			CartService cartService,
			CartLineItemService cartLineItemService) {
		this.productService = productService;
		this.usersService = usersService;
		this.cartService = cartService;
		this.cartLineItemService = cartLineItemService;
	}
	
	@GetMapping(value = { "/", "/home"})
	public  ModelAndView home() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		
		if(auth.getPrincipal() instanceof java.lang.String) {
			
			username = (String) auth.getPrincipal();
			
		} else if (auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			
			username = userDetails.getUsername();
		}
		
		Iterable<Product> productList = productService.getAllProducts();

		String role = "";
		String name = "";
		
		if(usersService.findByUsername(username).size() > 0) {
			role = usersService.findByUsername(username).get(0).getRole();
			name = usersService.findByUsername(username).get(0).getUsername();
		}
		ModelAndView modelAndView = new ModelAndView();
		
		//check if cart exists
		if(!username.equals("anonymousUser") ) {
			List<Users> currentUser = usersService.findByUsername(username);
			Long userId = currentUser.get(0).getId();
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
		}
		
		
		
		modelAndView.addObject("products", productList);
		modelAndView.addObject("role", role);
		modelAndView.addObject("name", name);
		
		modelAndView.setViewName("/home");
		return modelAndView;
	}
}
