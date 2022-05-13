package com.xoriant.delivery.spring_jdbctemplate.dao;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xoriant.delivery.spring_jdbctemplate.mapper.CategoryMapper;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;
import com.xoriant.delivery.spring_jdbctemplate.util.DBquries;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String addNewCategory(Category category) {
		int result = jdbcTemplate.update(DBquries.ADD_NEW_CATEGORY, category.getCategoryId(),
				category.getCategoryName().toUpperCase());
		if (result != 0) {
			return "====== New Category Added Succesfully =====";
		}
		return null;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String addNewListOfCategories(Category catLists) {

		int result = jdbcTemplate.update(DBquries.ADD_NEW_CATEGORY, catLists.getCategoryId(),
				catLists.getCategoryName());
		while (true) {
			if (result != 0) {
				System.out.println("New Category Added Succesfully ::" + catLists.getCategoryName());
				System.out.println("Do You want to add more ? 1) Yes 2) no");
				Scanner sc = new Scanner(System.in);
				int response = sc.nextInt();
				if (response != 1) {
					break;
				}

			}
		}
		return "====== New Lists of Categories added Succesfully ====";
	}

	@Override
	public Category findById(int categoryId) {

		CategoryMapper categoryMapper = new CategoryMapper();
		Category category = null;
		try {
			category = jdbcTemplate.queryForObject(DBquries.FIND_BY_ID, categoryMapper, categoryId);

		} catch (Exception e) {
			return null;
		}

		return category;
	}

	@Override
	public List<Category> fetchAllCategories() {
		CategoryMapper categoryMapper = new CategoryMapper();
		List<Category> catLists = jdbcTemplate.query(DBquries.FETCH_ALL_CATEGORIES, categoryMapper);
		List<Category> sortedLists = catLists.stream()
				.sorted((e1, e2) -> e1.getCategoryName().compareTo(e2.getCategoryName())).collect(Collectors.toList());
		return sortedLists;

	}

	@Override
	public String updateCategory(Category category) {

		int result = jdbcTemplate.update(DBquries.UPDATE_CATEGORY, category.getCategoryName().toUpperCase(),
				category.getCategoryId());
		if (result != 0) {
			return "==== Update Category Succesfully ====";
		}
		return "==== Not able to update the category =====";
	}

	@Override
	public String deleteCategoryId(int catetgoryId) {

		int result = jdbcTemplate.update(DBquries.DELETE_CATEGORY, catetgoryId);
		if (result != 0) {
			return "===== Delete Category Id Succesfully =====";
		}
		return "==== Not able to delete Category ID ====";
	}

}
