package com.xoriant.delivery.spring_jdbctemplate.dao;

import java.util.List;
import java.util.Optional;

import com.xoriant.delivery.spring_jdbctemplate.model.Category;

public interface CategoryDao {

	String addNewCategory(Category category);

	String addNewListOfCategories(Category catLists);

	Category findById(int categoryId);

	// Java 1.8 feature
	List<Category> fetchAllCategories();

	String updateCategory(Category category);

	String deleteCategoryId(int catetgoryId);
}
