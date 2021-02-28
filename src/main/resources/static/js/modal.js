$(window).click( function(e){   	
	
	if(e.target.id == "cart" ||
			e.target.id == "cartModalContent" ||
			e.target.id == "cartItems" ||
			e.target.id == "shoppingcart1" ||
			e.target.id == "shoppingcart2" ||
			e.target.id == "checkoutButton" ||
			$(event.target).attr('class') == "cartListItem" ||
			$(event.target).attr('class') == "cartproductImage" ||
			$(event.target).attr('class') == "cartProductName" || 
			$(event.target).attr('class') == "cartProductPrice" || 
			$(event.target).attr('class') == "cartQuantityTimes" || 
			$(event.target).attr('class') == "cartProductQuantity" ||
			$(event.target).attr('class') == "cartListItem" ||  
			$(event.target).attr('class') == "totalprice" ){
		
		$( "#cartModal" ).removeClass('displayNone');
		
	}else if(e.target.className == "addToCartButton"){ 
		return;
	}else{
		$( "#cartModal" ).addClass('displayNone');
	}
	
});
	