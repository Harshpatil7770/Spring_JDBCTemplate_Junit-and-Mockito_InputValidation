package com.xoriant.delivery.spring_jdbctemplate.main;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.xoriant.delivery.spring_jdbctemplate.test.Test;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, SQLException {

		Test test = new Test();
		test.showMainEcartMenu();
	}
}
