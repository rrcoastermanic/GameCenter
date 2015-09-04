package com.gamecenter.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gamecenter.data.dao.UsersDAO;
import com.gamecenter.data.model.Users;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public UsersDAOImpl()
	{
		
	}
	
	public UsersDAOImpl(SessionFactory sessionFactory)
	{
		
	}

	@Override
	public List<Users> list() {
		@SuppressWarnings("unchecked")
		List<Users> listUsers = (List<Users>) sessionFactory.getCurrentSession()
				.createCriteria(Users.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listUsers;
	}

	/**
	 * returns user by the ID set in the user object.
	 */
	@Override
	public Users getByID(Users user) {
		String hsql = "from USERS where userid = :userid";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hsql);
		query.setProperties(user);

		List<Users> listUsers = query.list();
		
		if(listUsers != null && !listUsers.isEmpty())
		{
			return listUsers.get(0);
		}
		
		return null;
	}
	
	@Transactional
	public Users attemptLogin(Users user)
	{
		String queryStr = "from Users where username = :username and password= :password";
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		
		List<Users> list = query.setProperties(user).list();
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		
		
		if(list != null && !list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public void SaveOrUpdateUser(Users user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}

	@Override
	public void deleteUser(Users user) {
		// TODO Auto-generated method stub
		
	}


}
