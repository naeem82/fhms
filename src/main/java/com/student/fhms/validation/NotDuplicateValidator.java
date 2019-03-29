package com.student.fhms.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.fhms.entity.Cow;
import com.student.fhms.service.CowService;

public class NotDuplicateValidator implements ConstraintValidator<NotDuplicateCowTagNo, String> {
	
	@Autowired
	private CowService cowService;
	

	@Override
	public void initialize(NotDuplicateCowTagNo notDuplicate) {
		
		
	}

	@Override
	public boolean isValid(String tagNo, ConstraintValidatorContext arg1) {
		Cow cow=cowService.getCowByTagNo(tagNo);
		if(cow==null)
			return true;
		return false;
	}

}
