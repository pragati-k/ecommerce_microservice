package com.nagarro.product_service.service;

import java.util.List;

import com.nagarro.product_service.model.Product;

public interface ProductService {
	
	
	public Product getProduct(Long id);

	public List<Product> getAllProduct();
	
	public void getAddProduct(Product product);

	public void deleteProduct(Long id);
}
