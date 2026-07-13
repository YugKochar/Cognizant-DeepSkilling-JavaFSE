package com.cognizant.account.controller;

public class AccountResponse {
	private String number;
	private String type;
	private long balance;

	public AccountResponse(String number, String type, long balance) {
		this.number = number;
		this.type = type;
		this.balance = balance;
	}

	public String getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public long getBalance() {
		return balance;
	}
}