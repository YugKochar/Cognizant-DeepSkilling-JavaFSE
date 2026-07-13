package com.cognizant.loan.controller;

public class LoanResponse {
	private String number;
	private String type;
	private long loan;
	private long emi;
	private int tenure;

	public LoanResponse(String number, String type, long loan, long emi, int tenure) {
		this.number = number;
		this.type = type;
		this.loan = loan;
		this.emi = emi;
		this.tenure = tenure;
	}

	public String getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public long getLoan() {
		return loan;
	}

	public long getEmi() {
		return emi;
	}

	public int getTenure() {
		return tenure;
	}
}