package com.xoriant.delivery.spring_jdbctemplate.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xoriant.delivery.spring_jdbctemplate.mapper.BrandMapper;
import com.xoriant.delivery.spring_jdbctemplate.model.Brand;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;
import com.xoriant.delivery.spring_jdbctemplate.util.DBquries;

@Repository
public class BrandDaoImpl implements BrandDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addNewBrand(Brand brand) {

		int result = jdbcTemplate.update(DBquries.ADD_NEW_BRAND, brand.getBrandId(), brand.getBrandName().toUpperCase(),
				brand.getCategory().getCategoryId());
		if (result != 0) {
			return "===== New Brand Added Succesfully ======";
		}
		return "===== Not able to add new Brand ======";
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String updatebrand(Brand brand) {
		try {
			jdbcTemplate.update(DBquries.UPDATE_BRAND, brand.getBrandName().toUpperCase(),
					brand.getCategory().getCategoryId(), brand.getBrandId());
		} catch (Exception e) {
			return "==== Category Not Updated Succesfully =====" + e.getMessage();
		}
		String msg = "=== Update Category Succefully ===";
		return msg;

	}

	@Override
	public List<Brand> fetchBrandByCategoryName(String categoryName) {
		List<Brand> listsofBrands = new ArrayList<Brand>();
		jdbcTemplate.query(DBquries.FETCH_BRAND_BY_CATEGORY_NAME, (ResultSet rs) -> {

			while (rs.next()) {
				Category category = new Category();
				Brand brand = new Brand();

				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				brand.setBrandId(rs.getInt(3));
				brand.setBrandName(rs.getString(4));
				brand.setCategory(category);

				listsofBrands.add(brand);

			}
		}, categoryName);

		List<Brand> sortedList = listsofBrands.stream()
				.sorted((o1, o2) -> o1.getBrandName().compareTo(o2.getBrandName())).collect(Collectors.toList());
		return sortedList;
	}

	@Override
	public List<Brand> fetchBrandByCategoryId(int categoryId) {
		List<Brand> brandLists = new ArrayList<Brand>();
		jdbcTemplate.query(DBquries.FETCH_BRAND_BY_CATEGORY_ID, (ResultSet rs) -> {
			while (rs.next()) {
				Category category = new Category();
				Brand brand = new Brand();

				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));

				brand.setBrandId(rs.getInt(3));
				brand.setBrandName(rs.getString(4));
				brand.setCategory(category);
				brandLists.add(brand);
			}
		}, categoryId);
		List<Brand> sortLists = brandLists.stream().sorted((o1, o2) -> o1.getBrandName().compareTo(o2.getBrandName()))
				.collect(Collectors.toList());
		return sortLists;
	}

	@Override
	public Brand fetchBrandById(int brandId) {
		BrandMapper mapper = new BrandMapper();
		Brand brand = null;
		try {
			brand = jdbcTemplate.queryForObject(DBquries.FETCH_BRAND_BY_BRAND_ID, mapper, brandId);
		} catch (Exception e) {
			return null;
		}
		return brand;
	}

	@Override
	public String deleteBrandById(int brandId) {

		int result = jdbcTemplate.update(DBquries.DELETE_BRAND_BY_ID, brandId);
		if (result != 0) {
			return "==== Delete Brand Succesfully ====";
		}
		return "=== Not able to delete brand ====";
	}

}
