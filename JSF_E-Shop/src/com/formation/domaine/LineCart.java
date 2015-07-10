package com.formation.domaine;

import com.formation.entity.Produit;

public class LineCart {
	
	Produit product;
	short quantity;
	
	//Getters & Setters
	public LineCart(Produit product){
		this.product = product;
		quantity = 1;
	}
	public Produit getProduit(){
		return product;
	}
	public short getQuantity(){
		return quantity;
	}
	public void setQuantity(short quantity){
		this.quantity = quantity;
	}
	public void incrementQuantity(){
		quantity++;
	}
	public void decrementQuantity(){
		quantity--;
	}
	public double getTotal(){
		double amount = 0;
		amount = (this.getQuantity() * product.getPrice().doubleValue());
		return amount;
	}
	
	
	

}
