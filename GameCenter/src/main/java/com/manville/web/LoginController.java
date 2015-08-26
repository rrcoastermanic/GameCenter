package com.manville.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String attemptLogin()
	{
		return null;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model)
	{
		System.out.println("Login??");
		return "login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRoot(Model model)
	{
		System.out.println("index");
		return "redirect:/login";
	}
}
