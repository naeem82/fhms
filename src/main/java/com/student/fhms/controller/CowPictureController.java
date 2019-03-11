package com.student.fhms.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.fhms.dto.FileBucket;
import com.student.fhms.entity.Cow;
import com.student.fhms.entity.CowPicture;
import com.student.fhms.service.CowPictureService;
import com.student.fhms.service.CowService;

@Controller
public class CowPictureController {
	@Autowired
	private CowPictureService cowPictureService;
	@Autowired
	private CowService cowService;
	
	@GetMapping("/showCowPictureForm")
	public String showCowPictureForm(Model theModel){
		FileBucket fileBucket=new FileBucket();
		theModel.addAttribute("fileBucket", fileBucket);
		
		return "cow-picture-form";
	}
	@PostMapping("/addCowPicture")
	public String addCowPicture(@ModelAttribute("fileBucket")  FileBucket bucket){
		
		
		saveCowPicture(bucket);
		
		System.out.println("File Name :"+bucket.getFile().getOriginalFilename());
		System.out.println("File size :"+bucket.getFile().getSize()/1024);
		System.out.println("File size :"+bucket.getFile().getContentType());
		System.out.println("File Description :"+bucket.getDescription());
		
		return "cow-picture-form";
	}
	public void saveCowPicture(FileBucket bucket){
		
		CowPicture cowPicture=new CowPicture();
		cowPicture.setFileName(bucket.getFile().getOriginalFilename());
		cowPicture.setDescription(bucket.getDescription());
		try {
			cowPicture.setImage(bucket.getFile().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cow cow=new Cow("777","red", 7, "MALE", null);
		cow.add(cowPicture);
		cowPicture.setFilePath("abc");
		cow.add(cowPicture);
		//cowPictureService.saveCowPicture(cowPicture);
		cowService.saveCow(cow);
	}
	@GetMapping("/showCowPicture")
	public String showCowPicture(Model model){
		CowPicture cowPicture=cowPictureService.getCowPicture(1);
		model.addAttribute("cowPicture", cowPicture);
		return "cow-picture-response";
	}

}
