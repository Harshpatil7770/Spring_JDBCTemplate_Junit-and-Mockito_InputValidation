package com.xoriant.delivery.spring_jdbctemplate.service;

import java.util.List;

import com.xoriant.delivery.spring_jdbctemplate.model.Brand;

public interface BrandService {

	String addNewBrand(Brand brand);

	String updateBrand(Brand brand);

	List<Brand> fetchBrandByCategoryName(String categoryName);

	List<Brand> fetchBrandByCategoryId(int categoryId);

	Brand fetchBrandById(int brandId);

	String deleteBrandById(int brandId);
}
