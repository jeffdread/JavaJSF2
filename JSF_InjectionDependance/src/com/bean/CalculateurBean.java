package com.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="calculateur")
@SessionScoped
public class CalculateurBean implements Serializable{	
	private static final long serialVersionUID = 1L;
	private String msg = "La somme est de : ";
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int add(int number1, int number2){
		return (number1)+(number2);
	}
}