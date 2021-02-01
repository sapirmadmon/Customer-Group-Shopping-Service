package com.example.demo.boundaries;

public class Product {
	private Long productId;

	public Product() {
		super();
	}

	public Product(Long productId) {
		super();
		this.productId = productId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductBoundary [productId=" + productId + "]";
	}
	
	
}
