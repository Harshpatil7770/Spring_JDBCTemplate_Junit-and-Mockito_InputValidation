package com.xoriant.delivery.spring_jdbctemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.delivery.spring_jdbctemplate.dao.ProductDao;
import com.xoriant.delivery.spring_jdbctemplate.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public String addNewProduct(Product product) {

		return productDao.addNewProduct(product);
	}

	@Override
	public String updateProduct(Product product) {

		return productDao.updateProduct(product);
	}

	@Override
	public List<Product> fetchAll() {
		
		return productDao.fetchAll();
	}

	@Override
	public List<Product> fetchProductByCategoryName(String categoryName) {
		
		return productDao.fetchAll();
	}

	@Override
	public List<Product> fetchProductByBrandName(String brandName) {
		
		return productDao.fetchProductByBrandName(brandName);
	}

	@Override
	public String deleteProduct(int productId) {
		
		return productDao.deleteProduct(productId);
	}

	@Override
	public Product findById(int productId) {
		
		return productDao.findById(productId);
	}

}
