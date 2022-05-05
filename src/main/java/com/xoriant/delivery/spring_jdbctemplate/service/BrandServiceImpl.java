package com.xoriant.delivery.spring_jdbctemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.delivery.spring_jdbctemplate.dao.BrandDao;
import com.xoriant.delivery.spring_jdbctemplate.model.Brand;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	public String addNewBrand(Brand brand) {

		return brandDao.addNewBrand(brand);
	}

	@Override
	public String updateBrand(Brand brand) {

		return brandDao.updatebrand(brand);
	}

	@Override
	public List<Brand> fetchBrandByCategoryName(String categoryName) {
		
		return brandDao.fetchBrandByCategoryName(categoryName);
	}

	@Override
	public List<Brand> fetchBrandByCategoryId(int categoryId) {
		
		return brandDao.fetchBrandByCategoryId(categoryId);
	}

	@Override
	public Brand fetchBrandById(int brandId) {
		
		return brandDao.fetchBrandById(brandId);
	}

	@Override
	public String deleteBrandById(int brandId) {
		
		return brandDao.deleteBrandById(brandId);
	}

}
