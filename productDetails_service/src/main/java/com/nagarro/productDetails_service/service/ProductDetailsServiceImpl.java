package com.nagarro.productDetails_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nagarro.productDetails_service.model.ProductDetails;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService{
	
	//fake product list
	List<ProductDetails> list = new ArrayList<>(List.of(
			new ProductDetails(100L, 230, 8, "Flexible", 1L),
			new ProductDetails(101L, 480, 7, "Comfy", 2L),
			new ProductDetails(102L, 650, 9, "Soft", 2L),
			new ProductDetails(103L, 21990, 1, "minimal", 4L)
			));
	

	@Override
	public List<ProductDetails> getAllDetails() {
	
		return this.list;
	}
	
	@Override
	public List<ProductDetails> getProductDetails(Long productId) {
		return list.stream().filter(productDetails -> productDetails.getProductId() == productId).collect(Collectors.toList());
	}

	@Override
	public List<ProductDetails> getAddDetails(ProductDetails details) {
		
		this.list.add(details);
		return list;
		
	}

	@Override
	public void deleteDetails(Long id) {
		
		this.list.removeIf(details -> details.getProduct_detailsId() == id);
	}

	@Override
	public void deleteAccToProduct(Long id) {
		
		this.list.removeIf(details -> details.getProductId() == id);
	}


}
