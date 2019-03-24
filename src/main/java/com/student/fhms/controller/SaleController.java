package com.student.fhms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		dataBinder.registerCustomEditor(Date.class, dateEditor);

		
	}
	
	@GetMapping("/showSaleList")
	public String showSaleList(Model model){
		List<Sale> sales=saleService.getSales();
		model.addAttribute("sales", sales);
		
		return "list-sale";
	}
	
	@GetMapping("/showSaleForm")
	public String showSaleForm(Model model){
		
		List<Cow> saleAbleCows=cowService.getSaleableCows();
		model.addAttribute("saleAbleCows", saleAbleCows);
		SaleDTO saleDTO=new SaleDTO();
		model.addAttribute("saleDTO", saleDTO);
		// Get all cows that are for sale
		
		//set the model with saleable cows so that sale form  can be populated with cows .
		
		return "cow-sale-form";
	}
	@PostMapping("/performSale")
	public String performSale(@Valid @ModelAttribute("saleDTO")SaleDTO saleDTO,BindingResult bindingResult,Model model){
		
		if(bindingResult.hasErrors()){
			List<Cow> saleAbleCows=cowService.getSaleableCows();
			model.addAttribute("saleAbleCows", saleAbleCows);
			
			return "cow-sale-form";
		}
		
		// Get Cow
		Cow cow=cowService.getCow(saleDTO.getCowId());
		 
		// Get and save Customer information
		Customer customer=saleDTO.getCustomer();
	//remove	customerService.saveCustomer(customer);
		
		//  Get and save sale information
		Sale sale=saleDTO.getSale();
		sale.setCustomer(customer);
		sale.addCow(cow);
	//remove  saleService.saveSale(sale);
		
		return "redirect:/showSaleList";
	}
	
	@GetMapping("/showSaleUpdateForm")
	public String showSaleUpdateForm(@RequestParam("saleId")int saleId,
			@RequestParam("cowId") int cowId,Model model){
		Sale sale=saleService.getSale(saleId);
		Cow soldCow=sale.getCows().get(0);
		Customer customer=sale.getCustomer();
		// Fill SaleDTO for Sale Update.
		SaleDTO saleDTO=new SaleDTO();
		saleDTO.fill(sale,customer,cowId);
		model.addAttribute("saleDTO", saleDTO);
		
		
		// Sale able cows + Selcted Saled Cow(in case we want to change cow)
		List<Cow> saleAbleCows=cowService.getSaleableCows();
		saleAbleCows.add(0, soldCow);
		model.addAttribute("saleAbleCows", saleAbleCows);
	
		return "cow-sale-form";
		
	}
	@GetMapping("/deleteSale")
	public String deleteSale(@RequestParam("saleId") int saleId){
		saleService.deleteSale(saleId);
		return "redirect:/showSaleList";
		
	}
	

}
