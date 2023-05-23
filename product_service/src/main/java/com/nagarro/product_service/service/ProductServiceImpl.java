package com.nagarro.product_service.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.nagarro.product_service.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	
	//fake product list	
	List<Product> list = new ArrayList<>(List.of(
			new Product(1L, "Cap"),
			new Product(2L, "Shoe"),
			new Product(3L, "Bag"),
			new Product(4L, "Phone")
			));
	
	@Override
	public Product getProduct(Long id) {
		return this.list.stream().filter(product -> product.getProductId() == id).findAny().orElse(null);
	}

	@Override
	public List<Product> getAllProduct() {
		return this.list;
	}

	@Override
	public void getAddProduct(Product product) {
		
		this.list.add(product);
		
	}
	
	@Override
	public void deleteProduct(Long id) {
		
		this.list.removeIf(product -> product.getProductId() == id);
	}
}
