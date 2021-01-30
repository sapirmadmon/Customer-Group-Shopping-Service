package com.example.demo.boundaries;

public class ProductBoundary {
	private Long productId;

	public ProductBoundary() {
		super();
	}

	public ProductBoundary(Long productId) {
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
