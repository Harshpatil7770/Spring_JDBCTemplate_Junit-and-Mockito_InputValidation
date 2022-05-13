package com.xoriant.delivery.spring_jdbctemplate.service;

import java.util.List;
import java.util.Optional;

import com.xoriant.delivery.spring_jdbctemplate.model.Category;
import com.xoriant.delivery.spring_jdbctemplate.model.Product;

public interface CategoryService {

	String addNewCategory(Category category);

	String addNewListOfCategories(Category catLists);

	Category findById(int categoryId);

	List<Category> fetchAllCategory();

	String updateCategory(Category category);

	String deleteCategory(int categoryId);
	
	

}
