package com.gamecenter.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "gamecenter", name = "users")
public class Users 
{
	@Id
	@Column(name = "userid", length=40)
	private String userid;
	@Column(name = "username", length = 36)
	private String username;
	@Column(name = "password", length = 40)
	private String password;
	@Column(name = "email", length = 254)
	private String email;
	
	@Column(name = "lastlogin")
	private Date lastLogin;
	@Column(name = "created")
	private Date created;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", lastLogin=" + lastLogin + ", created=" + created + "]";
	}
	
	
	
	
}
