package com.formation.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 1520318172495977648L;
	
	// Database
	private static final String[] users = { "anna:tata", "kate:toto"};
	
	private String username;
	private String password;
	
	private boolean loggedIn;
	
	@ManagedProperty(value= "#{navigationBean}")
	private NavigationBean navigationBean;
	
	
	
	
	
	public LoginBean() {
	}

	public LoginBean(String username, String password, boolean loggedIn,
			NavigationBean navigationBean) {
		super();
		this.username = username;
		this.password = password;
		this.loggedIn = loggedIn;
		this.navigationBean = navigationBean;
	}

	/**
	 * 
	 * Login operation.
	 */
	public String doLogin(){
		//System.out.println("Test_1");
		//Get every user from our sample database :)
		for(String user: users){
			String dbUsername = user.split(":")[0];
			String dbPassword = user.split(":")[1];
			//System.out.println("Test2");
			//Successful login
			if (dbUsername.equals(username) && dbPassword.equals(password)) {
				//System.out.println("Test3");
				loggedIn = true;
				//System.out.println("Test4");
				return navigationBean.redirectToWelcome();
			
				
			}
		}
		//Set login Error
		FacesMessage msg = new FacesMessage("login error !", "ERROR MSG");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		//To to login page
		return navigationBean.toLogin();
		
	}
	
	/**
	 * 
	 * Logout operation.
	 */
	public String doLogout(){
		// par default le user n'est pas authentifié
		loggedIn = false;
		
		// Set logout message
		FacesMessage msg = new FacesMessage("Logout success !", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return navigationBean.toLogin();
	}


	
	//Getters & Setters
	
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

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public static String[] getUsers() {
		return users;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	

}
