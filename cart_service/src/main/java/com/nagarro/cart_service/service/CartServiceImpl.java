package com.nagarro.cart_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.cart_service.model.Product;


@Service
public class CartServiceImpl implements CartService{

	List<Product> cart_list = new ArrayList<>();

	@Override
	public List<Product> getCart() {
		
		return this.cart_list;
	}

	@Override
	public void addToCart(Product product) {
		this.cart_list.add(product);
		
	}

	@Override
	public void removeFromCart(Long id) {
		
		this.cart_list.removeIf(product -> product.getProductId() == id);
		
	}

	@Override
	public void removeAll() {
		this.cart_list.removeAll(cart_list);
		
	}
	
}
