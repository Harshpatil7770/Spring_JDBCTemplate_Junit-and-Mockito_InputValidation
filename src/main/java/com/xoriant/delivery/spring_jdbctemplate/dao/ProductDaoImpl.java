package com.xoriant.delivery.spring_jdbctemplate.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xoriant.delivery.spring_jdbctemplate.mapper.ProductMapper;
import com.xoriant.delivery.spring_jdbctemplate.model.Brand;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;
import com.xoriant.delivery.spring_jdbctemplate.model.Product;
import com.xoriant.delivery.spring_jdbctemplate.util.DBquries;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String addNewProduct(Product product) {

		int result = jdbcTemplate.update(DBquries.ADD_NEW_PRODUCT, product.getProductId(),
				product.getProductName().toUpperCase(), product.getPrice(), product.getQuantity(),
				product.getDescription().toUpperCase(), product.getBrand().getBrandId(),
				product.getCategory().getCategoryId());
		if (result != 0) {
			return "========= New Product Added Succesfully ========";
		}
		return "===== Not able to add New Product ======";
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String updateProduct(Product product) {
		int result = jdbcTemplate.update(DBquries.UPDATE_PRODUCT, product.getProductName().toUpperCase(),
				product.getPrice(), product.getQuantity(), product.getDescription().toString(),
				product.getBrand().getBrandId(), product.getCategory().getCategoryId(), product.getProductId());

		if (result != 0) {
			return "===== Upddate Product Succesfully =====";
		}
		return "==== Not able to Upadte the product ====";
	}

	@Override
	public List<Product> fetchAll() {
		List<Product> productLists = new ArrayList<Product>();
		return jdbcTemplate.query(DBquries.FETCH_ALL_PRODUCT, (ResultSet rs) -> {
			while (rs.next()) {
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

				productLists.add(product);

			}

			List<Product> sortList = productLists.stream()
					.sorted((product1, product2) -> product1.getProductName().compareTo(product2.getProductName()))
					.collect(Collectors.toList());
			return sortList;
		});

	}

	@Override
	public List<Product> fetchProductByCategoryName(String categoryName) {
		List<Product> listsProduct = new ArrayList<Product>();
		return jdbcTemplate.query(DBquries.FETCH_PRODUCT_BY_CATGEORY_NAME, (ResultSet rs) -> {
			while (rs.next()) {
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

				listsProduct.add(product);

			}
			List<Product> sortList = listsProduct.stream()
					.sorted((product1, product2) -> product1.getProductName().compareTo(product2.getProductName()))
					.collect(Collectors.toList());
			if (sortList.contains(null)) {
				return null;
			}
			return sortList;

		}, categoryName);
	}

	@Override
	public List<Product> fetchProductByBrandName(String brandName) {
		List<Product> listsProduct = new ArrayList<Product>();
		return jdbcTemplate.query(DBquries.FETCH_PRODUCT_BY_BRAND_NAME, (ResultSet rs) -> {
			while (rs.next()) {
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

				listsProduct.add(product);

			}
			List<Product> sortList = listsProduct.stream()
					.sorted((product1, product2) -> product1.getProductName().compareTo(product2.getProductName()))
					.collect(Collectors.toList());
			return sortList;

		}, brandName);
	}

	@Override
	public List<Product> fetchProductInBetweenPriceRange(double minPrice, double maxPrice) {
		List<Product> listsProduct = new ArrayList<Product>();
		return jdbcTemplate.query(DBquries.FETCH_PRODUCT_IN_BETWEEN_PRICE_RANGE, (ResultSet rs) -> {
			while (rs.next()) {
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

				listsProduct.add(product);

			}
			List<Product> sortList = listsProduct.stream()
					.sorted((product1, product2) -> product1.getProductName().compareTo(product2.getProductName()))
					.collect(Collectors.toList());
			return sortList;

		}, minPrice, maxPrice);
	}

	@Override
	public List<Product> fetchProductAboveThePriceRange(double price) {
		List<Product> listsProduct = new ArrayList<Product>();
		return jdbcTemplate.query(DBquries.FETCH_PRODUCT_ABOVE_THE_PRICE_RANGE, (ResultSet rs) -> {
			while (rs.next()) {
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

				listsProduct.add(product);

			}
			List<Product> sortList = listsProduct.stream()
					.sorted((product1, product2) -> product1.getProductName().compareTo(product2.getProductName()))
					.collect(Collectors.toList());
			return sortList;

		}, price);
	}

	@Override
	public List<Product> fetchProductBelowThePriceRange(double price) {
		List<Product> listsProduct = new ArrayList<Product>();
		return jdbcTemplate.query(DBquries.FETCH_PRODUCT_BELOW_THE_PRICE_RANGE, (ResultSet rs) -> {
			while (rs.next()) {
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

				listsProduct.add(product);

			}
			List<Product> sortList = listsProduct.stream()
					.sorted((product1, product2) -> product1.getProductName().compareTo(product2.getProductName()))
					.collect(Collectors.toList());
			return sortList;

		}, price);
	}

	@Override
	public String deleteProduct(int productId) {

		int result = jdbcTemplate.update(DBquries.DELETE_PRODUCT_BY_ID, productId);
		if (result != 0) {
			return "===== Delete Product Succesfully =====";
		}

		return "===== Not able to delete Product =====";
	}

	@Override
	public Product findById(int productId) {
		ProductMapper mapper = new ProductMapper();
		Product result = jdbcTemplate.queryForObject(DBquries.FIND_PRODUCT_BY_ID, mapper, productId);
		if (result == null) {
			return null;
		}
		return result;
	}

}
