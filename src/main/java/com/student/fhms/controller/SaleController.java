package com.student.fhms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaleController {
	
	@GetMapping("/showSaleForm")
	public String showSaleForm(Model model){
		
		// Get all cows that are for sale
		
		//set the model with saleable cows so that sale form  can be populated with cows .
		
		return "cow-sale-form";
	}
	

}
