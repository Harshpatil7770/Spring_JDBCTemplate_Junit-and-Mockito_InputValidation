package com.xoriant.delivery.spring_jdbctemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.delivery.spring_jdbctemplate.dao.CategoryDao;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public String addNewCategory(Category category) {
		categoryDao.addNewCategory(category);
		String msg = "===== New Category Added Succsfully ====";
		return msg;
	}

	@Override
	public String addNewListOfCategories(List<Category> catLists) {
		categoryDao.addNewListOfCategories(catLists);
		String msg = "====== New Lists of Categories added Succesfully ====";
		return msg;
	}

	@Override
	public Category findById(int categoryId) {

		return categoryDao.findById(categoryId);
	}

	@Override
	public List<Category> fetchAllCategory() {
		List<Category> catLists = categoryDao.fetchAllCategories();
		return catLists;
	}

	@Override
	public String updateCategory(Category category) {

		Category cat = categoryDao.findById(category.getCategoryId());
		if (cat.getCategoryId() != 0) {
			categoryDao.updateCategory(category);
			return "Category Id Present in Database";
		}
		return "Category Id is not Present in Database";
	}

	@Override
	public String deleteCategory(int categoryId) {
		
		return categoryDao.deleteCategoryId(categoryId);
	}

}
