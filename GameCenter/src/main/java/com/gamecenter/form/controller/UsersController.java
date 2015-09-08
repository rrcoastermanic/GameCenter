package com.gamecenter.form.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gamecenter.form.model.Register;



@Controller
public class UsersController {
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ModelAndView doRegister(@ModelAttribute("registerForm") Register register, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			
		}
		
		// insert user
		
		return null;
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView register(Model model)
	{
		logger.debug("register()");
		
		return new ModelAndView("register","registerForm", new Register());
	}
	
	/*@RequestMapping(value = "/updateUser", RequestM)
	public ModelAndView updateUserInfo(Model model)
	{
		logger.debug("updateUserInfo",);
	}*/

}
