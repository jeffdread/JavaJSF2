package com.formation.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.formation.entity.Produit;

@ManagedBean(name="facade")
@SessionScoped
public class ProduitFacadeBean implements ProduitFacade {
	
	private static List<Produit> produits;
	
	private static int i = 1;
	
	
	@Override
	public Produit createProduit(Produit produit) {
		produit.setId(i++);
		produits.add(produit);
		return produit;
	}
	@Override
	public List<Produit> findProduit() {
		// TODO Auto-generated method stub
		return produits;
	}
	@Override
	public void delete(Produit produit) {
		// TODO Auto-generated method stub
		produits.remove(produit);
		
	}
	
	@PostConstruct
	private void init(){
		produits = new ArrayList<Produit>();
		
		produits.add(new Produit(i++, "Galaxy Tab 3", "Samsung", 200.0));
		produits.add(new Produit(i++, "Nexus 7", "Asus", 250.0));
		produits.add(new Produit(i++, "Archos 80 Titanium", "Archos", 160.0));
		produits.add(new Produit(i++, "Ipad Mini", "Apple", 300.0));
	}
	

}
