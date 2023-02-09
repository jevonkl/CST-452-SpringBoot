package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

	private List<ProductModel> products = new ArrayList<ProductModel>();

	public List<ProductModel> getProducts() {
		return this.products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}
}