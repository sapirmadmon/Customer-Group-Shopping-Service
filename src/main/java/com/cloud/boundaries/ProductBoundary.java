package com.cloud.boundaries;

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
}
