package com.gamecenter.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gamecenter.data.dao.UsersDAO;
import com.gamecenter.data.dao.impl.UsersDAOImpl;
import com.gamecenter.data.model.Users;
@EnableTransactionManagement
@Configuration
public class SpringDBConfig 
{
	@Bean(name = "dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://LOCALHOST:5432/GAMECENTER");
		dataSource.setUsername("postgres");
		dataSource.setPassword("abc123");
		
		return dataSource;
	}
	
	
	private Properties getHibernateProperties()
	{
		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		
		return props;
		
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource ds)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(ds);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Users.class);
		
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transMan = new HibernateTransactionManager(sessionFactory);
		
		return transMan;
	}
	
	@Autowired
	@Bean(name = "usersDAO")
	public UsersDAO usersDAO(SessionFactory sessionFactory)
	{
		return new UsersDAOImpl(sessionFactory);
	}
}
