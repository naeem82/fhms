package com.student.fhms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.fhms.dto.SaleDTO;
import com.student.fhms.entity.Cow;
import com.student.fhms.entity.Customer;
import com.student.fhms.entity.Sale;
import com.student.fhms.service.CowService;
import com.student.fhms.service.CustomerService;
import com.student.fhms.service.SaleService;

@Controller
public class SaleController {
	@Autowired
	private CowService cowService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SaleService saleService;
	
	@GetMapping("/showSaleForm")
	public String showSaleForm(Model model){
		
		List<Cow> cows=cowService.getSaleableCows();
		model.addAttribute("cows", cows);
		SaleDTO saleDTO=new SaleDTO();
		model.addAttribute("saleDTO", saleDTO);
		// Get all cows that are for sale
		
		//set the model with saleable cows so that sale form  can be populated with cows .
		
		return "cow-sale-form";
	}
	@PostMapping("/performSale")
	public String performSale(@ModelAttribute("saleDTO")SaleDTO saleDTO,Model model){
		// Get Cow
		Cow cow=cowService.getCow(saleDTO.getCowId());
		 
		// Get and save Customer information
		Customer customer=saleDTO.getCustomer();
		customerService.saveCustomer(customer);
		
		//  Get and save sale information
		Sale sale=saleDTO.getSale();
		sale.setCustomer(customer);
		sale.addCow(cow);
		saleService.saveSale(sale);
		
		return "sale-response";
	}
	

}
