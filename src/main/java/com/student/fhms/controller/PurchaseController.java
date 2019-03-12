package com.student.fhms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PurchaseController {
	
	@GetMapping("/showPurchaseForm")
	public String showPurchaseForm(Model model){
		// get Purchased Cow List
		
		// set to model so that form can be populate with purchased cows
		
		return "cow-purchase-form";
		
	}

}
