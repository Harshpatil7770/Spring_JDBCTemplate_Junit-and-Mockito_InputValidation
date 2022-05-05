package com.xoriant.delivery.spring_jdbctemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private int productId;

	private String productName;

	private double price;

	private int quantity;

	private String description;

	private Brand brand;

	private Category category;	
	
}
