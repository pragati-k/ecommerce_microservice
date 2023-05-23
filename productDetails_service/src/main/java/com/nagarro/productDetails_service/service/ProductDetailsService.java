package com.nagarro.productDetails_service.service;

import java.util.List;

import com.nagarro.productDetails_service.model.ProductDetails;

public interface ProductDetailsService {

	
	public List<ProductDetails> getAllDetails();
	public List<ProductDetails> getProductDetails(Long productId);
	

	public List<ProductDetails> getAddDetails(ProductDetails product);
	public void deleteDetails(Long id);
	public void deleteAccToProduct(Long id);
}
