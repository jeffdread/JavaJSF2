package com.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DecisionBean {

	public String calcul() {
		return Math.random() < 0.2 ? "success" : "echec";
	}
}