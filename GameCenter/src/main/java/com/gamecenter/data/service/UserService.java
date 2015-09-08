package com.gamecenter.data.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gamecenter.data.dao.UsersDAO;
import com.gamecenter.form.model.Login;

public interface UserService 
{
	
	public boolean attemptLogin(Login form);
	
	public boolean checkUserExists(String username);
}
