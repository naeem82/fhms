package com.student.fhms.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.fhms.dto.FileBucket;
import com.student.fhms.entity.Cow;
import com.student.fhms.entity.CowPicture;
import com.student.fhms.service.CowPictureService;
import com.student.fhms.service.CowService;



@Controller
public class CowPictureController {
	private Logger logger=Logger.getLogger(CowPictureController.class.getName());
	@Autowired
	private CowPictureService cowPictureService;
	@Autowired
	private CowService cowService;
	
	@GetMapping("/showCowPictureForm")
	public String showCowPictureForm(@RequestParam("cowId")int cowId,Model theModel){
		Cow cow=cowService.getCow(cowId);
		CowPicture cowPicture=cow.getLastPicture();
		FileBucket fileBucket=new FileBucket();
		fileBucket.setBase64ImageFile(cowPicture.getBase64imageFile());
		fileBucket.setCowId(cowId);
		theModel.addAttribute("fileBucket", fileBucket);
		
		return "cow-picture-form";
	}
	@PostMapping("/addCowPicture")
	public String addCowPicture(@ModelAttribute("fileBucket")  FileBucket bucket,Model model){
		
		
		saveCowPicture(bucket);
		
		List<Cow> cows=cowService.getCows();
		model.addAttribute("cows", cows);
		return "list-cow-pictures";
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
		Cow cow=cowService.getCow(bucket.getCowId());
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
	@GetMapping("/showCowsWithPicture/{pageId}")
	public String showCowsWithPicture(@PathVariable int pageId,Model model){
	   ////////////////////////For Paging//////////////////////////////////////////////
		int recordsToDisplay=5;
		logger.info("Default value of Cow Pictures---------------------------:"+pageId);
		if(pageId==1){
			
		}else
		{
			pageId=(pageId-1)*recordsToDisplay+1;
		}
		long totalRecords=cowService.countCowsInSystemYetNotSold();
		int totalPages=(int)Math.ceil((double)totalRecords/recordsToDisplay);
		model.addAttribute("totalPages", totalPages);
		///////////////////////////////////////////////////////////////////////////////
		List<Cow> cows=cowService.getCowsInSystemYetNotSold(pageId, recordsToDisplay);
		
		logger.info("showCowsWithPicture --------- cow Size :"+cows.size());
		model.addAttribute("cows", cows);
		
		return "list-cow-pictures";
	}
	@GetMapping("/viewSingleCowPictures")
	public String viewSingleCowPictures(@RequestParam("cowId")int cowId,Model model){
	List<CowPicture> cowPictures=cowPictureService.getPicturesByCowId(cowId);	
		System.out.println("--------------viewSingleCowPictures------------:"+cowPictures.size());
		model.addAttribute("cowPictures", cowPictures);
		model.addAttribute("cowId", cowId);
		return "view-single-cow-pictures";
	}
	@GetMapping("/deleteCowPicture")
	public String deleteCowPicture(@RequestParam("pictureId") int pictureId,
			@RequestParam("cowId") int cowId,Model model){
		model.addAttribute("cowId", cowId);
		cowPictureService.deleteCowPicture(pictureId);
		//List<CowPicture> cowPictures=cowPictureService.getPicturesByCowId(cowId);
		return "redirect:/viewSingleCowPictures";
	}

}
