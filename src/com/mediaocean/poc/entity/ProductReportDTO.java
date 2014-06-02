package com.mediaocean.poc.entity;



public class ProductReportDTO{
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getSumOfProduct() {
		return sumOfProduct;
	}

	public void setSumOfProduct(Double sumOfProduct) {
		this.sumOfProduct = sumOfProduct;
	}

	public Long getProductCount() {
		return productCount;
	}

	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}

	private Product product;
	
	private Double sumOfProduct;
	
	private Long productCount;
	
	
}
