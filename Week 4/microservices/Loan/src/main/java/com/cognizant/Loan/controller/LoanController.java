package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	@GetMapping("/loans/{number}")
	public LoanResponse getLoan(@PathVariable String number) {
		return new LoanResponse(number, "car", 400000, 3258, 18);
	}
}