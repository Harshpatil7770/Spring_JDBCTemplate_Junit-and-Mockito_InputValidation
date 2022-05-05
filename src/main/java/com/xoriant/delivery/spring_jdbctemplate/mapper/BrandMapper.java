package com.xoriant.delivery.spring_jdbctemplate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xoriant.delivery.spring_jdbctemplate.model.Brand;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;

public class BrandMapper implements RowMapper<Brand> {

	@Override
	public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
		Brand brand = new Brand();
		Category category = new Category();
		brand.setBrandId(rs.getInt(1));
		brand.setBrandName(rs.getString(2));
		category.setCategoryId(rs.getInt(3));
		brand.setCategory(category);
		return brand;
	}

}
