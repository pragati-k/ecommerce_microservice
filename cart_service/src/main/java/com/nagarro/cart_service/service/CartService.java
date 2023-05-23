package com.nagarro.cart_service.service;

import java.util.List;

import com.nagarro.cart_service.model.Product;


public interface CartService {
	

	public List<Product> getCart();
	
	public void addToCart(Product product);
	
	public void removeFromCart(Long id);
	
	public void removeAll();
	
}
