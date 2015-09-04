package com.gamecenter.form.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gamecenter.data.service.UserService;
import com.gamecenter.form.model.Login;

@Component
public class LoginValidator implements Validator{

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> c)
	{
		return Login.class.equals(c);
	}
	


	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Login login = (Login) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Empty.loginForm.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Empty.loginForm.password");
		
		if(!errors.hasErrors())
		{
			if(!userService.attemptLogin(login))
			{
				errors.reject("login.incorrect.creds");
			}
		}
		
		
		
	}
}
