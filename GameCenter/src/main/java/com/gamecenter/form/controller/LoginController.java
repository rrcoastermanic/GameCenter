package com.gamecenter.form.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gamecenter.form.model.Login;
import com.gamecenter.form.validator.LoginValidator;

@Controller
public class LoginController {
	
	@Autowired
	private LoginValidator loginValidator;
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	@InitBinder
	protected void initBinder(WebDataBinder binder)
	{
		binder.setValidator(loginValidator);
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String attemptLogin(@ModelAttribute("loginForm")@Validated Login login, 
			BindingResult result, Model model)
	{
		
		logger.trace("LoginController::attemptLogin()");
		logger.debug(login.toString());
		logger.debug(result.toString());
		logger.debug(model.toString());
		
		if(result.hasErrors())
		{
			System.out.println("has Errors");
			//populateDefaultModel(model);
			return "login";
		}
		
		return null;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model)
	{
		logger.trace("LoginController::login()");
		logger.debug(model.toString());
		
		return new ModelAndView("login","loginForm",new Login());
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRoot(Model model)
	{
		logger.trace("LoginController::getRoot()");
		logger.debug(model.toString());
		
		System.out.println("index");
		return "redirect:/login";
	}
}
