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

import com.xoriant.delivery.spring_jdbctemplate.dao.BrandDao;
import com.xoriant.delivery.spring_jdbctemplate.model.Brand;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
class BrandServiceImplTest {

	@Mock
	BrandDao brandDao;

	@InjectMocks
	BrandServiceImpl brandServiceImpl;

	private Brand brand;

	private Category category;

	@BeforeEach
	public void setup() {
		brand = new Brand();
		brand.setBrandId(101);
		brand.setBrandName("Oppo");
		category = new Category(11, "SmartPhones");

	}

	@Test
	public void addNewBrand() {

		when(brandDao.addNewBrand(brand)).thenReturn("New Brand Added !!!");
		String result = brandDao.addNewBrand(brand);
		assertEquals(result, brandServiceImpl.addNewBrand(brand));
	}

	@Test
	public void updateBrand() {
		when(brandDao.fetchBrandById(101)).thenReturn(brand);
		Brand result = brandDao.fetchBrandById(101);
		assertNotNull(result);
		brand.setBrandName("Lenovo");
		category.setCategoryId(12);
		category.setCategoryName("SmartPhones");
		brand.setCategory(category);
		when(brandDao.updatebrand(brand)).thenReturn("Brand Updated Succesfully !");
		assertEquals(brandDao.updatebrand(brand), brandServiceImpl.updateBrand(brand));
	}

	@Test
	public void fetchBrandByCategoryName() {
		List<Brand> brandLists = new ArrayList<Brand>();
		when(brandDao.fetchBrandByCategoryName("SmartPhones")).thenReturn(brandLists);
		List<Brand> result = brandDao.fetchBrandByCategoryName("SmartPhones");
		assertNotNull(result);
		assertEquals(result, brandServiceImpl.fetchBrandByCategoryName("SmartPhones"));
	}

	@Test
	public void fetchBrandByCategoryId() {
		List<Brand> brandLists = new ArrayList<Brand>();
		when(brandDao.fetchBrandByCategoryId(11)).thenReturn(brandLists);
		List<Brand> result = brandDao.fetchBrandByCategoryId(11);
		assertNotNull(result);
		assertEquals(result, brandServiceImpl.fetchBrandByCategoryId(11));
	}

	@Test
	public void fetchBrandById() {
		when(brandDao.fetchBrandById(101)).thenReturn(brand);
		Brand result = brandDao.fetchBrandById(101);
		assertNotNull(result);
		assertEquals(result, brandServiceImpl.fetchBrandById(101));
	}

	@Test
	public void deleteBrandById() {
		when(brandDao.deleteBrandById(101)).thenReturn("deleted Succsfully");
		String result = brandDao.deleteBrandById(101);
		assertNotNull(result);
		assertEquals(result, brandServiceImpl.deleteBrandById(101));
	}
}
