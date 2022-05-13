package com.xoriant.delivery.spring_jdbctemplate.service;

import java.util.List;

import com.xoriant.delivery.spring_jdbctemplate.model.Product;

public interface ProductService {

	String addNewProduct(Product product);

	String updateProduct(Product product);

	List<Product> fetchAll();

	Product findById(int productId);

	List<Product> fetchProductByCategoryName(String categoryName);

	List<Product> fetchProductByBrandName(String brandName);

	public String deleteProduct(int productId);
}
