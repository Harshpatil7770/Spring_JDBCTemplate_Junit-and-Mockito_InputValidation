package com.xoriant.delivery.spring_jdbctemplate.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import com.xoriant.delivery.spring_jdbctemplate.dao.ProductDao;
import com.xoriant.delivery.spring_jdbctemplate.model.Brand;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;
import com.xoriant.delivery.spring_jdbctemplate.model.Product;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
class ProductServiceImplTest {

	@Mock
	ProductDao productDao;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	private Product product;
	private Brand brand;
	private Category category;

	@BeforeEach
	public void setup() {
		product = new Product();
		product.setProductId(101);
		product.setProductName("Oppo F1f");
		product.setPrice(15999);
		product.setDescription("Selfi Expert");
		product.setQuantity(50);
		// brand.setBrandId(11);
		// brand.setBrandName("Oppo");
//		 category.setCategoryId(51);
//		 category.setCategoryName("SmartPhones");
//		// product.setBrand(brand);
//		 product.setCategory(category);

	}

	@Test
	public void addNewProduct() {
		when(productDao.addNewProduct(product)).thenReturn("New Product Added Succesfully");
		String result = productDao.addNewProduct(product);
		assertEquals(result, productServiceImpl.addNewProduct(product));
	}

	@Test
	public void updateProduct() {
		when(productDao.findById(101)).thenReturn(product);
		Product result = productDao.findById(101);
		assertNotNull(result);
		product.setProductName("Oppo F17");
		when(productDao.updateProduct(product)).thenReturn("Updated Product Succesfully !!!");
		String response = productDao.updateProduct(product);
		assertEquals(response, productServiceImpl.updateProduct(product));
	}

	@Test
	public void findById() {
		when(productDao.findById(101)).thenReturn(product);
		Product result = productDao.findById(101);
		assertNotNull(result);
		assertEquals(result, productServiceImpl.findById(101));
	}

	@Test
	public void fetchAll() {
		List<Product> prodLists = new ArrayList<Product>();
		prodLists.add(product);
		Product product1 = new Product();
		product1.setProductId(102);
		product1.setProductName("Oppo F17");
		product1.setPrice(17999);
		product1.setDescription("Selfi Expert");
		product1.setQuantity(50);
		prodLists.add(product1);
		when(productDao.fetchAll()).thenReturn(prodLists);
		assertEquals(prodLists, productServiceImpl.fetchAll());
	}

	@Test
	public void fetchProductByCategoryName() {
		List<Product> prodLists = new ArrayList<Product>();
		prodLists.add(product);
		when(productDao.fetchProductByCategoryName("SmartPhones")).thenReturn(prodLists);
		List<Product> result = productDao.fetchProductByCategoryName("SmartPhones");
		assertNotNull(result);
		assertEquals(result, productServiceImpl.fetchProductByCategoryName("SmartPhones"));
	}

	@Test
	public void fetchProductByBrandName() {
		List<Product> prodLists = new ArrayList<Product>();
		prodLists.add(product);
		when(productDao.fetchProductByBrandName("Samsung")).thenReturn(prodLists);
		List<Product> result = productDao.fetchProductByBrandName("Samsung");
		assertNotNull(result);
		assertEquals(result, productServiceImpl.fetchProductByBrandName("Samsung"));
	}

	@Test
	public void deleteProduct() {
		when(productDao.deleteProduct(101)).thenReturn("Deleted Succesfullly");
		String result = productDao.deleteProduct(101);
		assertNotNull(result);
		assertEquals(result, productServiceImpl.deleteProduct(101));
	}

}
