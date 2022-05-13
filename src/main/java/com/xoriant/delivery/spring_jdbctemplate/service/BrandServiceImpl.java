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

		brandDao.addNewBrand(brand);
		String msg = "New Brand Added !!!";
		return msg;
	}

	@Override
	public String updateBrand(Brand brand) {
		brandDao.updatebrand(brand);
		String msg = "Brand Updated Succesfully !";
		return msg;
	}

	@Override
	public List<Brand> fetchBrandByCategoryName(String categoryName) {

		List<Brand> existingBrand = brandDao.fetchBrandByCategoryName(categoryName);
		if (existingBrand != null) {
			brandDao.fetchBrandByCategoryName(categoryName);
			return existingBrand;
		}

		return null;
	}

	@Override
	public List<Brand> fetchBrandByCategoryId(int categoryId) {
		List<Brand> existingBrand = brandDao.fetchBrandByCategoryId(categoryId);
		if (existingBrand != null) {
			brandDao.fetchBrandByCategoryId(categoryId);
			return existingBrand;
		}
		return null;

	}

	@Override
	public Brand fetchBrandById(int brandId) {

		Brand existingBrand = brandDao.fetchBrandById(brandId);
		if (existingBrand.getBrandId() != 0) {
			return brandDao.fetchBrandById(brandId);
		}
		return null;
	}

	@Override
	public String deleteBrandById(int brandId) {

		return brandDao.deleteBrandById(brandId);
	}

}
