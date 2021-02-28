$(document).ready(function(){
	
	//ShippingAddress constructor
	function ShippingAddress(first_name, 
			last_name, 
			shipping_address_1,
			shipping_address_2, 
			shipping_postcode,
			shipping_city, 
			shipping_state, 
			shipping_country,
			shipping_phone){
		this.first_name = first_name;
		this.last_name = last_name;
		this.shipping_address_1 = shipping_address_1;
		this.shipping_address_2 = shipping_address_2;
		this.shipping_postcode = shipping_postcode;
		this.shipping_city = shipping_city;
		this.shipping_state = shipping_state;
		this.shipping_country = shipping_country;
		this.shipping_phone = shipping_phone;
	}
	
	//BillingAddress Constructor
	function BillingAddress(billing_first_name,
			billing_last_name,
			billing_address_1, 
			billing_address_2,
			billing_postcode, 
			billing_city, 
			billing_state,
			billing_country, 
			billing_phone){
		this.billing_first_name = billing_first_name;
		this.billing_last_name = billing_last_name;
		this.billing_address_1 = billing_address_1;
		this.billing_address_2 = billing_address_2;
		this.billing_postcode =  billing_postcode;
		this.billing_city = billing_city;
		this.billing_state = billing_state;
		this.billing_country = billing_country;
		this.billing_phone = billing_phone;
	}
	
	//PaymentInfo constructor
	function PaymentInfo(card_number, 
			card_name,
			card_exp_date){
		this.card_number = card_number;
		this.card_name = card_name;
		this.card_exp_date = card_exp_date;
	}
	
	
	function PaymentDto(shippingAddress, billingAddress, paymentInfo){
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.paymentInfo = paymentInfo;
	}
	
	$( "#reroutetoPayment" ).click(function() { 
		

		var first_name = $("#sfirstname").val();
		var last_name = $("#slastname").val();
		var shipping_address_1 = $("#saddress1").val();
		var shipping_address_2 = $("#saddress2").val();
		var shipping_postcode = $("#spost").val();
		var shipping_city = $("#scity").val();
		var shipping_state = $("#sstate").val();
		var shipping_country = $("#scountry").val();
		var shipping_phone = $("#sphone").val();
		
		var billing_first_name = $("#bfirstname").val();
		var billing_last_name = $("#blastname").val();
		var billing_address_1 = $("#baddress1").val();
		var billing_address_2 = $("#baddress2").val();
		var billing_postcode = $("#bpost").val();
		var billing_city = $("#bcity").val();
		var billing_state = $("#bstate").val();
		var billing_country = $("#bcountry").val();
		var billing_phone = $("#bphone").val();
		
		var card_number = $("#ccnumber").val();
		var card_name = $("#ccname").val();
		var card_exp_date = "10/2020";
		
		var shippingAddress = new ShippingAddress(
				first_name,
				last_name,
				shipping_address_1,
				shipping_address_2,
				shipping_postcode,
				shipping_city,
				shipping_state,
				shipping_country,
				shipping_phone);
		
		var billingAddress = new BillingAddress(
				billing_first_name,
				billing_last_name,
				billing_address_1,
				billing_address_2,
				billing_postcode,
				billing_city,
				billing_state,
				billing_country,
				billing_phone);
		
		var paymentInfo = new PaymentInfo(
				card_number,
				card_name,
				card_exp_date);
		
		var paymentDto = new PaymentDto(shippingAddress, billingAddress, paymentInfo);
		
		var paymenetJson = JSON.stringify(paymentDto);
		var xhttp = new XMLHttpRequest();
		xhttp.open("POST", "/api/order/save", true);
		
		var formData = new FormData();
		
		formData.append("paymentDetails", paymenetJson);
		
		xhttp.send(formData);
		xhttp.onload = function(){
			window.location.href = "/review";
		}
    });
	
	
	$( "#placeOrder" ).click(function() { 
		window.location.href = "/confirmation";
	});
	
	$( "#reviewBack" ).click(function() { 
		window.location.href = "/payment";
	});
	
	$( "#paymentBack" ).click(function() { 
		window.location.href = "/checkout";
	});
	
	$( "#backtostore" ).click(function() { 
		window.location.href = "/";
	});
});




