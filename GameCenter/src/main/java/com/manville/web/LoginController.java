package com.manville.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manville.form.model.Login;

@Controller
public class LoginController {

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String attemptLogin(@ModelAttribute("loginForm") Login login, 
			BindingResult result, Model model)
	{
		System.out.println("attemptLogin");
		System.out.println(login.toString());
		
		return null;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model)
	{
		System.out.println("Login??");
		return new ModelAndView("login","loginForm",new Login());
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRoot(Model model)
	{
		System.out.println("index");
		return "redirect:/login";
	}
}
