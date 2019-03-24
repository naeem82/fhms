package com.student.fhms.controller;

import java.text.DateFormat;
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

import com.student.fhms.dto.CowAndPictureDTO;
import com.student.fhms.dto.PurchaseDTO;
import com.student.fhms.entity.Cow;
import com.student.fhms.entity.Customer;
import com.student.fhms.entity.Purchase;
import com.student.fhms.service.CowService;
import com.student.fhms.service.CustomerService;
import com.student.fhms.service.PurchaseService;

@Controller
public class PurchaseController {
	@Autowired
	private CowService cowService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private PurchaseService purchaseService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		dataBinder.registerCustomEditor(Date.class, dateEditor);
		

		
	}
	
	@GetMapping("/showPurchaseList")
	public String showPurchaseList(Model model){
		List<Purchase> purchases=purchaseService.getPurchaseInformationCowsThatAreNotSold();
		model.addAttribute("purchases", purchases);
		return "list-purchase";
	}
	
	@GetMapping("/showPurchaseForm")
	public String showPurchaseForm(Model model){
		// get Purchased Cow List
		List<Cow> purchasedCows=cowService.getPurchasedCows();
		// set to model so that form can be populate with purchased cows
		model.addAttribute("cows",purchasedCows);
		
		PurchaseDTO purchaseDTO=new PurchaseDTO();
		model.addAttribute("purchaseDTO", purchaseDTO);
		
		
		return "cow-purchase-form";
		
	}
	@PostMapping("/performPurchase")
	public String performPurchase(@Valid @ModelAttribute("purchaseDTO") PurchaseDTO purchaseDTO,BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){
			// get Purchased Cow List
			List<Cow> purchasedCows=cowService.getPurchasedCows();
			// set to model so that form can be populate with purchased cows
			model.addAttribute("cows",purchasedCows);
			
			return "cow-purchase-form";
		}
		Cow cow=cowService.getCow(purchaseDTO.getCowId());
		
		
		// Saving Customer Information
		Customer customer=purchaseDTO.getCustomer();
	//remove customerService.saveCustomer(customer);
		
		
		// Saving Purchase information
		Purchase purchase=purchaseDTO.getPurchase();
		purchase.setCustomer(customer);
		purchase.addCow(cow);
	//remove	purchaseService.savePurchase(purchase);
		return "redirect:/showPurchaseList";
	}
	
	@GetMapping("/showPurchaseUpdateForm")
	public String showPurchaseUpdateForm(@RequestParam("purchaseId") int purchaseId,
						@RequestParam("cowId")int cowId,Model model){
		Purchase purchase=purchaseService.getPurchase(purchaseId);
		Customer customer=purchase.getCustomer();
		Cow cow=purchase.getCows().get(0);
		
		
		// Fill DTO
		PurchaseDTO purchaseDTO=new PurchaseDTO();
		purchaseDTO.fillDTO(purchase, customer, cowId);
		model.addAttribute("purchaseDTO", purchaseDTO);
		
		// Purchase able cow + Selcted Purchase Cow(in case we want to change cow)
		
		List<Cow> purchasedCows=cowService.getPurchasedButNotSoldCows();
		//purchasedCows.add(0, cow);
		model.addAttribute("cows",purchasedCows);
		
		return "cow-purchase-form";
	}
	@GetMapping("/deletePurchase")
	public String deletePurchase(@RequestParam("purchaseId")int purchaseId){
		purchaseService.deletePurchase(purchaseId);
		return "redirect:/showPurchaseList";
	}
	

}
