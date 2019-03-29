package com.student.fhms.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy={NotDuplicateValidator.class})
@Target({ElementType.METHOD,ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)

public @interface NotDuplicateCowTagNo {
	public String message()default "Duplicate Value / Already Exists in DB";
	public String value() default "TagNO";
	
	Class<?>[]groups() default{};
	Class<? extends Payload> []payload()default {};
	

}
