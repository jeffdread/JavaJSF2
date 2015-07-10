package com.formation.domaine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.formation.entity.Produit;

public class ShoppingCart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	List<LineCart> items;
	int numberOfItems;
	double total;
	
	public ShoppingCart(){
		items = new ArrayList<LineCart>();
	}
	
	public synchronized void addItem(Produit product){
		
		boolean newItem = true;
			for(LineCart scItem : items){
				if (scItem.getProduit().getId() == product.getId()) {
					newItem = false;
					scItem.incrementQuantity();
				
			}
			}
			if (newItem) {
				LineCart scItem = new LineCart(product);
				items.add(scItem);
			}
	}

	public synchronized void update(Produit product, String quantity){
		short qty = 1;
		
		//cast quantity as short
		qty = Short.parseShort(quantity);
		
		if (qty >= 0) {
			LineCart item = null;
			for (LineCart scItem : items) {
				if (scItem.getProduit().getId()==product.getId()) {
					
					if (qty != 0) {
						//set item quantity to new value
						scItem.setQuantity(qty);
						
					}else {
						//if quantity equals 0, save item and break
						item = scItem;
						break;
					}
					
				}
				
			}
			if (item != null) {
				//remove from cart
				items.remove(item);
				
			}
		}
	}
	
	public synchronized int getNumberOfItems(){
		numberOfItems = 0 ;
		for (LineCart scItem : items) {
			numberOfItems += scItem.getQuantity();
			
		}
		return numberOfItems;
	}
	
	public synchronized double getSubtotal(){
		double amount = 0;
		
		for (LineCart scItem : items) {
			Produit product = (Produit) scItem.getProduit();
			amount += (scItem.getQuantity() * product.getPrice().doubleValue());
			
		}
		return amount;
		
	}
	
	public synchronized void calculateTotal(String surcharge){
		//Charge suppl (ex: tva)
		double amount = 0;
		
		//cast surcharge as double
		double s = Double.parseDouble(surcharge);
		
		amount = this.getSubtotal();
		amount += s;
		total = amount;
		
	}
	public synchronized double getTotal(){
		return total;
		
	}
	public synchronized void clear(){
		items.clear();
		numberOfItems = 0;
		total = 0;
		
	}
public List<LineCart> getItems(){
	return items;
	
	
}
public void setItems(List<LineCart> items){
	this.items = items;
}
	
}