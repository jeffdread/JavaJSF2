package com.formation.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean {
	
	private String userName;
	private int age;
	private String email;
	
	//Getters & setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	//Methode to String
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserBean [userName=" + userName + ", age=" + age + "]";
	}
	
	

}
