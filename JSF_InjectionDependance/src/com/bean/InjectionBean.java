package com.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class InjectionBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{calculateur}")
	private CalculateurBean calculateurBean;
	private int number1;
	private int number2;
	private String result;
	
	//logique de calcul
		public String calcul(){
			result = calculateurBean.getMsg() + calculateurBean.add(number1, number2);
			return null;
		}
//getter et setter
		
		
	public CalculateurBean getCalculateurBean() {
		return calculateurBean;
	}

	public int getNumber1() {
		return number1;
	}


	public void setNumber1(int number1) {
		this.number1 = number1;
	}


	public int getNumber2() {
		return number2;
	}


	public void setNumber2(int number2) {
		this.number2 = number2;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public void setCalculateurBean(CalculateurBean calculateurBean) {
		this.calculateurBean = calculateurBean;
	}	
}