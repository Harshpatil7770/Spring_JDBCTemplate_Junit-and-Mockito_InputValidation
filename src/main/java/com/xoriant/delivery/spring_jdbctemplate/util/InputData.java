package com.xoriant.delivery.spring_jdbctemplate.util;

import com.xoriant.delivery.spring_jdbctemplate.model.Category;
import com.xoriant.delivery.spring_jdbctemplate.validation.InputValidation;

public class InputData {

	private static Category category = new Category();

	public static Category addNewCategory() {
		System.out.println("Enter Category Name :: ");
		String categoryName = InputValidation.inputStringValidation();
		category.setCategoryName(categoryName);
		return category;
	}
}
