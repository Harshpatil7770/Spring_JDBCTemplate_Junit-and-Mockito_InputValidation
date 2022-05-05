package com.xoriant.delivery.spring_jdbctemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

	private int brandId;

	private String brandName;

	private Category category;
}
