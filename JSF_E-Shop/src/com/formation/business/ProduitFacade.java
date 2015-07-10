package com.formation.business;

import java.util.List;

import com.formation.entity.Produit;

public interface ProduitFacade {
	
	public Produit createProduit(Produit produit);
	public List<Produit> findProduit();
	public void delete(Produit produit);

}
