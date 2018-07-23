package com.accenture.lkm.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeValidator implements ConstraintValidator<EmployeeValidatorVal, String>{//name of the related annotation
	@Override
	public void initialize(EmployeeValidatorVal arg0) { //name of the related annotation
	}
	@Override
	public boolean isValid(String employeeName, ConstraintValidatorContext arg1) {
		//Validation Logic
		if(employeeName==null){
			return false;
		}
		if (employeeName.length()<3) {
			return false;
		}else{
			return true;
		}
	}
}
