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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.student.fhms.dto.CowAndPictureDTO;
import com.student.fhms.entity.Cow;
import com.student.fhms.entity.CowPicture;
import com.student.fhms.service.CowService;

@Controller
public class CowController {
	
	// To make copy of file in case of Update cow
	private MultipartFile fileCopy;
	@Autowired
	private  CowService cowService;
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		dataBinder.registerCustomEditor(Date.class, dateEditor);
		
	}
	
	@GetMapping("/showCows")
	public String showCows(Model model){
		//List<Cow> cows=cowService.getCows();
		List<Cow> cows=cowService.getCowsInSystemYetNotSold();
		model.addAttribute("cows",cows);
		return "list-cows";
	}
	@GetMapping("/showCowAddForm")
	public String showCowAddForm(Model theModel){
		CowAndPictureDTO  cowAndPictureDTO=new CowAndPictureDTO();
		theModel.addAttribute("cowAndPictureDTO",cowAndPictureDTO);
		
		return "cow-form-add";
	}
	@PostMapping("/addCow")
	public String addCow(@Valid @ModelAttribute("cowAndPictureDTO") CowAndPictureDTO dto,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			System.out.println("Binding Result :----------------------------->"+bindingResult);
			return "cow-form-add";
		}
		
		if(dto.getFile().getSize()==0){
			dto.setFile(fileCopy);
		}
		Cow cow=dto.getCow();
		CowPicture cowPicture=dto.getCowPicture();
		cow.add(cowPicture);
		cowService.saveCow(cow);
		
		return "redirect:/showCows";
	}
	@PostMapping("/updateCow")
	public String updateCow(@ModelAttribute("cowAndPictureDTO") CowAndPictureDTO dto){
		if(dto.getFile().getSize()==0){
			dto.setFile(fileCopy);
		}
		Cow cow=dto.getCow();
		CowPicture cowPicture=dto.getCowPicture();
		
		System.out.println("----------------------update cow controller------------------"+cowPicture.getFileName());
		cow.add(cowPicture);
		cowService.saveCow(cow);
		return "redirect:/showCows";
	}
	
	@GetMapping("/showCowUpdateForm")
	public String showCowUpdateForm(@RequestParam("cowId") int id ,Model theModel){
		
		Cow cow=cowService.getCow(id);
		System.out.println("---------------------------------id:"+id);
		CowAndPictureDTO dto=new CowAndPictureDTO();
		dto.fillDTO(cow);
		fileCopy=dto.getFile();
		
		
		theModel.addAttribute("cowAndPictureDTO", dto);
				
		
		return "cow-form-add";
	}
	
	@GetMapping("/deleteCow")
	public String deleteCow(@RequestParam("cowId") int id){
		cowService.deleteCow(id);
		return "redirect:/showCows";
	}

}
