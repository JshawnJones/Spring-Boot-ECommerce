$(document).ready(function(){
	cart = [];
	var obj = {};
	var totalprice = 0;
	
	// Product Constructor
	function Product(id, name, image, price, inventory) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.inventory = inventory;
	}
	
	// CartLineItem DTO Constructor
	function CartLineItemDto(product, quantity){
		this.product = product;
		this.quantity = quantity;
	}
	
	//get initial cart info
	if($(".cartProduct").length > 0){
		$(".cartProduct").each(function() {
			
			var id = $(this).find( ".cartProductName" ).attr("id");
			var name = $(this).find( ".cartProductName" ).attr("name");
			var image = $(this).find( ".cartproductImage" ).attr("src");
			var price = $(this).find( ".cartProductPrice" ).attr("price");
			var inventory = $(this).find( ".cartProductQuantity" ).attr("quantity");

			var product = new Product(id, name, image, price, inventory);
			var cartLineItemDto = new CartLineItemDto(product, inventory);
			
			cart.push(cartLineItemDto);
		});
		$( "#checkoutButton" ).removeClass('displayNone');
		$( "#reroutetoLogin" ).removeClass('displayNone');
	}
	
	
	$(".addToCartButton").click(function() { 
		var id = Number($(this).attr("id"));
		var name = $(this).attr("product");
		var image = $(this).attr("image");
		var price = Number($(this).attr("price"));
		
		totalprice = 0;
		addToCart(id, name, image, price, null);
		
		$("#cartItems").append("<li class='cartListItem'><div class='totalprice'>"
				+"Total Price: $" + totalprice
				+"</div></li>");
		
		
		if($("#username").length === 1){
			postCart(cart);
		}
		
		displayCart();
		
	});

	
	function addToCart(id, name, image, price, inventory) {
		
		$("#cartItems").empty();
		
		var found = false;

		for(var item in cart) {
			
			if(cart[item].product.name === name) {
				cart[item].quantity ++;
				
				found = true;
			}
		} 
		if(found){
			
		}else{
			var product = new Product(id, name, image, price, inventory);
			var cartLineItemDto = new CartLineItemDto(product, 1);
			
			cart.push(cartLineItemDto);			
		}
		
		cart.forEach(function(entry){
			
			var lineprice = (entry.quantity  * entry.product.price);
			
			totalprice = totalprice + lineprice;
			
			cartContents(entry);
		});
		
	}

	function displayCart(){
		$( "#cartModal" ).removeClass('displayNone');
		
		if(cart.length > 0){
			$( "#checkoutButton" ).removeClass('displayNone');
			$( "#reroutetoLogin" ).removeClass('displayNone');
		}
	}
	
	function cartContents(entry){
		var eachproduct = entry.product;
		var lineprice = (entry.quantity * eachproduct.price);
		
		
		$("#cartItems").append("<li class='cartListItem cartProduct'>"
				+ "<img class='cartproductImage' "
				+ "src='"+eachproduct.image+"'></img >"
				+ "<div class='cartProductName'>"
				+ eachproduct.name+"</div>"
				+"<div class='cartQuantityTimes'>x</div>"
				+ "<div class='cartProductQuantity'>"
				+ entry.quantity
				+ "</div>"
				+ "<div class='cartProductPrice'>$"+lineprice+"</div>"
				+"</li>");
	}
	
	function postCart(cart){
		
		var cartJson = JSON.stringify(cart);
		var xhttp = new XMLHttpRequest();
		xhttp.open("POST", "/api/cart/save", true);
		
		var formData = new FormData();
		
		formData.append("cart", cartJson);
		formData.append("totalprice", totalprice);
		
		xhttp.send(formData);
	}
	
	$( "#checkoutButton" ).click(function() { 
		if(cart.length > 0){
			window.location.href = "/checkout";
		}

    });
	
	
	$( "#reroutetoLogin" ).click(function() { 
		window.location.href = "/login";
	});
	
	
	$( "#paymentButton" ).click(function() { 
		
		window.location.href = "/payment";
    });
	
	$( "#checkoutBack" ).click(function() { 
		window.location.href = "/";
	});
	
	
	
});




