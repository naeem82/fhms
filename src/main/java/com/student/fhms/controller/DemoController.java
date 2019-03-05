package com.student.fhms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.fhms.entity.Cow;
import com.student.fhms.service.CowService;

@Controller
public class DemoController {
	@Autowired
	 private CowService cowService;
	@RequestMapping("/")
	public String welcome(){
		Cow cow=new Cow("red", 7, "MALE", null);
		cowService.saveCow(cow);
		System.out.println("-----------------------Object have been saved----------------------------");
		return "welcom";
	}

}
