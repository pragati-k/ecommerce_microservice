package com.nagarro.cart_service.model;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private long productId;
	private String name;
	
	List<ProductDetails> details_list = new ArrayList<ProductDetails>();

	
	public Product() {
		super();
	}


	public Product(long productId, String name) {
		this.productId = productId;
		this.name = name;
	}
	

	public Product(long productId, String name, List<ProductDetails> details_list) {
		this.productId = productId;
		this.name = name;
		this.details_list = details_list;
	}


	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductDetails> getDetails_list() {
		return details_list;
	}

	public void setDetails_list(List<ProductDetails> details_list) {
		this.details_list = details_list;
	}

	
}
