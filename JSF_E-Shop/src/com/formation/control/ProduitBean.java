package com.formation.control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.formation.business.ProduitFacade;
import com.formation.entity.Produit;

@ManagedBean
@RequestScoped
public class ProduitBean {
	
	@ManagedProperty(value="#{facade}")
	private ProduitFacade produitFacade;
	
	public List<Produit> getProduitList(){
		return produitFacade.findProduit();
	}
	
	public void setProduitFacade(ProduitFacade produitFacade){
	this.produitFacade = produitFacade;
	}

}
