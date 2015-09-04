package com.gamecenter.data.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamecenter.data.dao.UsersDAO;
import com.gamecenter.data.model.Users;
import com.gamecenter.data.service.UserService;
import com.gamecenter.form.model.Login;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UsersDAO usersDAO;
	
	public boolean attemptLogin(Login form) {
		
		System.out.println("attemptLogin");
		// map login form action to users model
		Users users = new Users();
		users.setUsername(form.getUsername());
		users.setPassword(form.getPassword());
		
		Users dbUsers = usersDAO.attemptLogin(users);
		
		if(dbUsers != null)
		{
			return true;
		}
		
		return false;
	}
	
}
