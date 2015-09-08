package com.gamecenter.data.dao;

import java.util.List;

import com.gamecenter.data.model.Users;

public interface UsersDAO {

	public List<Users> list();
	
	public Users getByID(Users user);
	
	public void SaveOrUpdateUser(Users user);
	
	public void deleteUser(Users user);
	
	public Users attemptLogin(Users user);
	
	public int getUsernameCount(Users user);
}
