package com.formation.control;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.formation.domaine.ShoppingCart;
import com.formation.entity.Produit;




@ManagedBean(name = "caddie")
@SessionScoped
public class CaddieBean {
	
	private ShoppingCart shoppingCart;
	

	@PostConstruct
	public void init(){
		shoppingCart = new ShoppingCart();
	}
	
	
	public boolean isVide(){
		return (shoppingCart.getNumberOfItems() <= 0)?false:true;
	}
	

	public void ajouter(Produit product){
		shoppingCart.addItem(product);
	}
	
	public ShoppingCart getShoppingCart(){
		return shoppingCart;
	}
	
	public void setShoppingCart(ShoppingCart shoppingCart){
		this.shoppingCart = shoppingCart;
	}

}
