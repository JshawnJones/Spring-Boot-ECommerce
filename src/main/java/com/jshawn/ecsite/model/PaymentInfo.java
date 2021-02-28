package com.jshawn.ecsite.model;


public class PaymentInfo {

	private String card_number;
	
	private String card_name;
	
	private String card_exp_date;

	public PaymentInfo(String card_number, String card_name, String card_exp_date) {
		this.card_number = card_number;
		this.card_name = card_name;
		this.card_exp_date = card_exp_date;
	}

	
	
	public PaymentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public String getCard_exp_date() {
		return card_exp_date;
	}

	public void setCard_exp_date(String card_exp_date) {
		this.card_exp_date = card_exp_date;
	}
	
	
}
