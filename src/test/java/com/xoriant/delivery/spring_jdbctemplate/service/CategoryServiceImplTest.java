package com.xoriant.delivery.spring_jdbctemplate.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

import com.xoriant.delivery.spring_jdbctemplate.dao.CategoryDao;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
class CategoryServiceImplTest {

	@Mock
	CategoryDao categoryDao;

	@InjectMocks
	CategoryServiceImpl categoryServiceImpl;

	private Category category;

	@BeforeEach
	public void setup() {
		category = new Category();
		category.setCategoryId(101);
		category.setCategoryName("SmartPhones");
	}

	@Test
	public void addNewCategory() {
		when(categoryDao.addNewCategory(category)).thenReturn("===== New Category Added Succsfully ====");
		String result = categoryDao.addNewCategory(category);
		assertNotNull(result);
		assertEquals(result, categoryServiceImpl.addNewCategory(category));
	}

	@Test
	public void addNewListOfCategories() {
		when(categoryDao.addNewListOfCategories(category))
				.thenReturn("====== New Lists of Categories added Succesfully ====");
		String result = categoryDao.addNewListOfCategories(category);
		assertNotNull(result);
		assertEquals(result, categoryServiceImpl.addNewListOfCategories(category));
	}

	@Test
	public void findById() {

		when(categoryDao.findById(101)).thenReturn(category);
		Category result = categoryDao.findById(101);
		assertNotNull(result);
		assertEquals(result, categoryServiceImpl.findById(101));
	}

	@Test
	public void fetchAllCategory() {
		List<Category> catLists = new ArrayList<Category>();
		catLists.add(category);
		Category category1 = new Category(102, "Laptops");
		catLists.add(category1);
		when(categoryDao.fetchAllCategories()).thenReturn(catLists);
		List<Category> result = categoryDao.fetchAllCategories();
		assertNotNull(result);
		assertEquals(2, categoryServiceImpl.fetchAllCategory().size());
	}

	@Test
	public void updateCategory() {
		when(categoryDao.findById(101)).thenReturn(category);
		Category result = categoryDao.findById(101);
		assertNotNull(result);
		category.setCategoryName("FootWear");
		when(categoryDao.updateCategory(result)).thenReturn("Category Id Present in Database");
		assertEquals(categoryDao.updateCategory(result), categoryServiceImpl.updateCategory(category));
	}

	@Test
	public void deleteCategory() {
		when(categoryDao.findById(101)).thenReturn(category);
		Category result = categoryDao.findById(101);
		assertNotNull(result);
		assertEquals(categoryDao.deleteCategoryId(101), categoryServiceImpl.deleteCategory(101));
	}
}
