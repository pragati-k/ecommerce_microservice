package com.nagarro.cart_service.model;

public class ProductDetails {

	private long product_detailsId;
	private String price;
	private int size;
	private String design;
	
	private long productId;
 
	
	
	public ProductDetails() {
		super();
	}
	public long getProduct_detailsId() {
		return product_detailsId;
	}
	public void setProduct_detailsId(long product_detailsId) {
		this.product_detailsId = product_detailsId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	
	
}
