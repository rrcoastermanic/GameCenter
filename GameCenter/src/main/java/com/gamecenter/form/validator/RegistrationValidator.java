package com.gamecenter.form.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gamecenter.data.service.UserService;
import com.gamecenter.form.model.Register;

public class RegistrationValidator implements Validator{

	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> c) {
		// TODO Auto-generated method stub
		return Register.class.equals(c);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Register register = (Register) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "register.empty.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "register.empty.confirmPass");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "register.empty.email");
		
		if(!register.getPassword().equals(register.getConfirmPassword()))
		{
			errors.rejectValue("password", "register.password.match");
		}
		
		if(userService.checkUserExists(register.getUsername()))
		{
			errors.rejectValue("username", "username already exists");
		}
		
		if(!validateEmail(register.getEmail()))
		{
			errors.rejectValue("email", "regisiter.invalid.email"); 
		}
		
		
		
	}
	
	private boolean validateEmail(String email)
	{
		String regex = "/(.+)@(.+){2,}\\.(.+){2,}/";
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(email);
		
		
		return matcher.matches();
	}

}
