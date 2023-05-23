package com.nagarro.productDetails_service.model;

public class ProductDetails {

	private long product_detailsId;
	private float price;
	private int size;
	private String design;
	
	private long productId;
 
	
	
	public ProductDetails(long product_detailsId, float price, int size, String design, long productId) {
		super();
		this.product_detailsId = product_detailsId;
		this.price = price;
		this.size = size;
		this.design = design;
		this.productId = productId;
	}
	

	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getProduct_detailsId() {
		return product_detailsId;
	}


	public void setProduct_detailsId(long product_detailsId) {
		this.product_detailsId = product_detailsId;
	}


	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
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
