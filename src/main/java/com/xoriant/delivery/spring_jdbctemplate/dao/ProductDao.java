package com.xoriant.delivery.spring_jdbctemplate.dao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import com.xoriant.delivery.spring_jdbctemplate.model.Product;

public interface ProductDao {

	String addNewProduct(Product product);

	String updateProduct(Product product);

	Product findById(int productId);

	// Java 1.8 feature
	List<Product> fetchAll();

	// Java 1.8 feature
	List<Product> fetchProductByCategoryName(String categoryName);

	// Java 1.8 feature
	List<Product> fetchProductByBrandName(String brandName);

	// Java 1.8 feature
	List<Product> fetchProductInBetweenPriceRange(double minPrice, double maxPrice);

	// Java 1.8 feature
	List<Product> fetchProductAboveThePriceRange(double price);

	// Java 1.8 feature
	List<Product> fetchProductBelowThePriceRange(double price);

	String deleteProduct(int productId);

}
