package com.xoriant.delivery.spring_jdbctemplate.dao;

import java.util.List;

import com.xoriant.delivery.spring_jdbctemplate.model.Brand;

public interface BrandDao {

	String addNewBrand(Brand brand);

	String updatebrand(Brand brand);
    
	// Java 1.8 feature
	List<Brand> fetchBrandByCategoryName(String categoryName);

	// Java 1.8 feature
	List<Brand> fetchBrandByCategoryId(int categoryId);

	Brand fetchBrandById(int brandId);

	String deleteBrandById(int brandId);
}
