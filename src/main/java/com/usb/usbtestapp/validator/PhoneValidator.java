package com.usb.usbtestapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
	
	private boolean onlyNumber = false;
	
	@Override
	public void initialize(Phone phone) {
		this.onlyNumber = phone.onlyNumber();
	}
	
	public boolean isValid(String input, ConstraintValidatorContext cxt) {
		if (input == null) {
			return false;
		}
		if (this.onlyNumber) {
			return input.matches("[0-9]*");
		}
		return input.matches("[0-9()-]*");
	}
}
