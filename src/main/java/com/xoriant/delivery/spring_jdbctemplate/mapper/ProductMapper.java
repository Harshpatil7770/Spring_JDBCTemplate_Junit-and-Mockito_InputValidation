package com.xoriant.delivery.spring_jdbctemplate.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xoriant.delivery.spring_jdbctemplate.model.Brand;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;
import com.xoriant.delivery.spring_jdbctemplate.model.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		Brand brand = new Brand();
		Category category = new Category();
		product.setProductId(rs.getInt(1));
		product.setProductName(rs.getString(2));
		product.setPrice(rs.getDouble(3));
		product.setQuantity(rs.getInt(4));
		product.setDescription(rs.getString(5));
		brand.setBrandId(rs.getInt(6));
		brand.setBrandName(rs.getString(7));
		category.setCategoryId(rs.getInt(8));
		category.setCategoryName(rs.getString(9));
		product.setBrand(brand);
		product.setCategory(category);

		return product;
	}

}
