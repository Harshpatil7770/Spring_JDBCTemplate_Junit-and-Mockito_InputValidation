package com.xoriant.delivery.spring_jdbctemplate.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xoriant.delivery.spring_jdbctemplate.dao.BrandDao;
import com.xoriant.delivery.spring_jdbctemplate.dao.CategoryDao;
import com.xoriant.delivery.spring_jdbctemplate.dao.ProductDao;
import com.xoriant.delivery.spring_jdbctemplate.model.Brand;
import com.xoriant.delivery.spring_jdbctemplate.model.Category;
import com.xoriant.delivery.spring_jdbctemplate.model.Product;
import com.xoriant.delivery.spring_jdbctemplate.util.InputData;
import com.xoriant.delivery.spring_jdbctemplate.validation.InputValidation;

public class Test {

	private static Scanner sc = new Scanner(System.in);

	public void showMainEcartMenu() {

		int choice = 1;
		do {
			System.out.println("============== Welcome To Ecart App ============");
			System.out.println("1) Category");
			System.out.println("2) Brand");
			System.out.println("3) Product");
			System.out.println("$ Which Operations do you want to perform \n Please Enter Your choice :: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				showCategoryDepartmentDetails();
				break;
			case 2:
				showBrandDepartmentDetails();
				break;
			case 3:
				showProductDepartmentDetails();
				break;
			default:
				System.out.println("Please enter available choice number !!!");
				System.out.println("========================================");
			}
			System.out.println("Do You Want To Visit Main Ecart Menu? 1)Yes 2)No");
			choice = InputValidation.inputIntegerValidation();
		} while (choice == 1);
	}

	public void showCategoryDepartmentDetails() {

		int choice = 1;
		do {

			ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
			CategoryDao categoryDao = (CategoryDao) ac.getBean("categoryDaoImpl");
			Category category = new Category();

			System.out.println("====== Welcome To Category Department =====");
			System.out.println("1) Add New Category ");
			System.out.println("2) Add New List of Category");
			System.out.println("3) Find Category By Category Id ");
			System.out.println("4) Fetch All Category (Alpabetical order) ");
			System.out.println("5) Update Category ");
			System.out.println("6) Delete Category ");
			System.out.println("7) Read Data From CSV File");
			System.out.println("Enter Your Choice :: ");
			int ch = InputValidation.inputIntegerValidation();

			switch (ch) {
			case 1:
				// InputData.addNewCategory();
				System.out.println("You have selected \n1)Add New Category");
				System.out.println("Enter Category Name :: ");
				String categoryName = InputValidation.inputStringValidation();
				category.setCategoryName(categoryName);
				String categoryResponse = categoryDao.addNewCategory(category);
				System.out.println(categoryResponse + " Category Name :: " + category.getCategoryName());
				break;
			case 2:
				System.out.println("You have selected \n1)Add New List Of Categories");
				System.out.println("Enter Category Name :: ");
				String catListsName = InputValidation.inputStringValidation();
				category.setCategoryName(catListsName);
				String catListsResponse = categoryDao.addNewListOfCategories(category);
				System.out.println(catListsResponse);
				break;
			case 3:
				System.out.println("You have selected \n 2)Find Category By Category Id");
				System.out.println("Enter category Id :: ");
				int catId = InputValidation.inputIntegerValidation();
				Category existCat = categoryDao.findById(catId);
				System.out.println(existCat);
				break;
			case 4:
				System.out.println("You have selected \n 3)Fetch All Category");
				categoryDao.fetchAllCategories().forEach(System.out::println);
				break;
			case 5:
				System.out.println("You have selected \n 4)Update Category");
				System.out.println("Enter category Id ");
				int categoryId = InputValidation.inputIntegerValidation();
				System.out.println("Enter category Name ");
				String catName = InputValidation.inputStringValidation();
				category.setCategoryId(categoryId);
				category.setCategoryName(catName);
				String message = categoryDao.updateCategory(category);
				System.out.println(message);
				break;
			case 6:
				System.out.println("You have selected \n 5)Delete Category");
				System.out.println("Enter category Id ");
				int catsId = InputValidation.inputIntegerValidation();
				String deleteCatMessage = categoryDao.deleteCategoryId(catsId);

				System.out.println(deleteCatMessage);
				break;
			}
			System.out.println("Do You Want to continue? 1) Yes 2) No");
			choice = InputValidation.inputIntegerValidation();
		} while (choice == 1);
	}

	public void showBrandDepartmentDetails() {

		int choice = 1;
		do {

			ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
			BrandDao brandDao = (BrandDao) ac.getBean("brandDaoImpl");
			Brand brand = new Brand();
			Category category = new Category();
			System.out.println("====== Welcome To Brand Department =====");
			System.out.println("1) Add New Brand ");
			System.out.println("2) Update Brand ");
			System.out.println("3) Fetch Brand By Category Name");
			System.out.println("4) Fetch Brand By Category Id ");
			System.out.println("5) Fetch Brand By Brand Id");
			System.out.println("6) Delete Brand By brand Id");
			System.out.println("Enter Your Choice :: ");
			int ch = InputValidation.inputIntegerValidation();

			switch (ch) {
			case 1:
				System.out.println("You have selected \n 6)Add New Brand");
				System.out.println("Enter brand Name ");
				String brandName = InputValidation.inputStringValidation();
				brand.setBrandName(brandName);

				System.out.println("Enter category Id ");
				int cateId = InputValidation.inputIntegerValidation();
				category.setCategoryId(cateId);

				brand.setCategory(category);
				String newBrandAdded = brandDao.addNewBrand(brand);
				System.out.println(newBrandAdded);
				break;
			case 2:
				System.out.println("You have selected \n 7)Update Brand");

				System.out.println("Enter brand Id ");
				int existingBrandId = InputValidation.inputIntegerValidation();

				System.out.println("Enter brand name ");
				String newBrandName = InputValidation.inputStringValidation();

				System.out.println("Enter category Id");
				int newCatId = InputValidation.inputIntegerValidation();
				category.setCategoryId(newCatId);

				brand.setBrandId(existingBrandId);
				brand.setBrandName(newBrandName);
				brand.setCategory(category);

				String updateBrand = brandDao.updatebrand(brand);
				System.out.println(updateBrand);
				break;
			case 3:
				System.out.println("You have selected \n 8)Fetch Brand By Category Name");
				System.out.println("Enter category name ");
				String fetchBrandbyCategoryname = InputValidation.inputStringValidation();
				brandDao.fetchBrandByCategoryName(fetchBrandbyCategoryname).forEach(System.out::println);
				break;
			case 4:
				System.out.println("You have selected \n 9)Fetch Brand By Category Id");
				System.out.println("Enter Category Id");
				int catID = InputValidation.inputIntegerValidation();
				brandDao.fetchBrandByCategoryId(catID).forEach(System.out::println);
				break;
			case 5:
				System.out.println("You have selected \n 10)Fetch Brand By Brand Id");
				System.out.println("Enter Brand Id ");
				int brandId = InputValidation.inputIntegerValidation();
				System.out.println(brandDao.fetchBrandById(brandId));
				break;
			case 6:
				System.out.println("You have selected \n 11)Delete Brand By brand Id");
				System.out.println("Enter brand Id");
				int deleteBrandId = InputValidation.inputIntegerValidation();
				System.out.println(brandDao.deleteBrandById(deleteBrandId));
				break;
			}
			System.out.println("Do You Want to continue? 1) Yes 2) No");
			choice = InputValidation.inputIntegerValidation();
		} while (choice == 1);
	}

	public void showProductDepartmentDetails() {

		int choice = 1;
		do {

			ApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
			ProductDao productDao = (ProductDao) ac.getBean("productDaoImpl");
			Category category = new Category();
			Brand brand = new Brand();
			Product product = new Product();
			System.out.println("====== Welcome To Product Department =====");
			System.out.println("1) Add New Product");
			System.out.println("2) Update Product");
			System.out.println("3) Fetch All Product");
			System.out.println("4) Fetch All Product Based on Category Name");
			System.out.println("5) Fetch All Product Based on Brand Name");
			System.out.println("6) Fetch All Product Based on the Price Range");
			System.out.println("7) Fetch All Product Based on above the Price Range");
			System.out.println("8) Fetch All Product Based on below the Price Range");
			System.out.println("9) Delete Product ");
			System.out.println("10) Read Data From CSV File");
			System.out.println("Enter Your Choice :: ");
			int ch = InputValidation.inputIntegerValidation();

			switch (ch) {
			case 1:
				System.out.println("You have selected \n 12)Add New Product");
				System.out.println("Enter product Name");
				String productName = sc.next();

				System.out.println("Enter Product Price");
				double price = InputValidation.inputDoubleValidation();

				System.out.println("Enter product quantity");
				int quantity = InputValidation.inputIntegerValidation();

				System.out.println("Enter product description");
				String description = sc.next();

				System.out.println("Enter brand id ");
				int prodBrandId = InputValidation.inputIntegerValidation();
				brand.setBrandId(prodBrandId);

				System.out.println("Enter category id ");
				int prodCategoryId = InputValidation.inputIntegerValidation();
				category.setCategoryId(prodCategoryId);

				product.setProductName(productName);
				product.setPrice(price);
				product.setQuantity(quantity);
				product.setDescription(description);
				product.setBrand(brand);
				product.setCategory(category);

				System.out.println(productDao.addNewProduct(product));
				break;
			case 2:
				System.out.println("You have selected \n 13)Update Product");

				System.out.println("Enter Product Id");
				int existingProductId = InputValidation.inputIntegerValidation();

				System.out.println("Enter product Name");
				String newProductName = sc.next();

				System.out.println("Enter Product Price");
				double newPrice = InputValidation.inputDoubleValidation();

				System.out.println("Enter product quantity");
				int newQuantity = InputValidation.inputIntegerValidation();

				System.out.println("Enter product description");
				String newQescription = sc.next();

				System.out.println("Enter brand id ");
				int newProdBrandId = InputValidation.inputIntegerValidation();
				brand.setBrandId(newProdBrandId);

				System.out.println("Enter category id ");
				int newProdCategoryId = InputValidation.inputIntegerValidation();
				category.setCategoryId(newProdCategoryId);

				product.setProductId(existingProductId);
				product.setProductName(newProductName);
				product.setPrice(newPrice);
				product.setQuantity(newQuantity);
				product.setDescription(newQescription);
				product.setBrand(brand);
				product.setCategory(category);
				System.out.println(productDao.updateProduct(product));
				break;
			case 3:
				System.out.println("You have selected \n 14)Fetch All Products");
				productDao.fetchAll().forEach(System.out::println);
				break;
			case 4:
				System.out.println("You have selected \n 15)Fetch All Products Based on Category Name");
				System.out.println("Enter Category name");
				String productCatName = InputValidation.inputStringValidation();

				productDao.fetchProductByCategoryName(productCatName).forEach(System.out::println);
				break;
			case 5:
				System.out.println("You have selected \n 16)Fetch All Products Based on Brand Name");
				System.out.println("Enter Brand name");
				String productBrandName = InputValidation.inputStringValidation();

				productDao.fetchProductByBrandName(productBrandName).forEach(System.out::println);
				break;
			case 6:
				System.out.println("You have selected \n 17)Fetch All Product Based on the Price Range");
				System.out.println("Enter minium Price ");
				double minPrice = InputValidation.inputDoubleValidation();
				System.out.println("Enter maximun Price ");
				double maxPrice = InputValidation.inputDoubleValidation();
				productDao.fetchProductInBetweenPriceRange(minPrice, maxPrice).forEach(System.out::println);
				break;
			case 7:
				System.out.println("You have selected \n 18)Fetch All Product Based on the above the Price Range");
				System.out.println("Enter minium Price ");
				double abovePriceRange = InputValidation.inputDoubleValidation();
				productDao.fetchProductAboveThePriceRange(abovePriceRange).forEach(System.out::println);
				break;
			case 8:
				System.out.println("You have selected \n 19)Fetch All Product Based on the below the Price Range");
				System.out.println("Enter minium Price ");
				double belowPriceRange = InputValidation.inputDoubleValidation();
				productDao.fetchProductBelowThePriceRange(belowPriceRange).forEach(System.out::println);
				break;
			case 9:
				System.out.println("You have selected \n 20)Delete Product ");
				System.out.println("Enter Product Id");
				int existProductId = InputValidation.inputIntegerValidation();
				System.out.println(productDao.deleteProduct(existProductId));
				break;
			case 10:
				System.out.println("You have selected \n 20)Fetch Product By Id");
				System.out.println("Enter Product Id");
				int exitProdId = InputValidation.inputIntegerValidation();
				System.out.println(productDao.findById(exitProdId));
				break;

			}
			System.out.println("Do You Want to continue? 1) Yes 2) No");
			choice = InputValidation.inputIntegerValidation();
		} while (choice == 1);
	}

	/*
	 * public void showMainEcartMenu() {
	 * 
	 * // "com/xoriant/delivery/spring_jdbctemplate/test/application-context.xml"
	 * int num = 1; do {
	 * 
	 * ApplicationContext ac = new
	 * ClassPathXmlApplicationContext("application-context.xml"); CategoryDao
	 * categoryDao = (CategoryDao) ac.getBean("categoryDaoImpl"); BrandDao brandDao
	 * = (BrandDao) ac.getBean("brandDaoImpl"); ProductDao productDao = (ProductDao)
	 * ac.getBean("productDaoImpl");
	 * 
	 * System.out.println("==============  Welcome To Ecart App ============");
	 * System.out.println("1) Add New Category ");
	 * System.out.println("2) Add New List of Category");
	 * System.out.println("3) Find Category By Category Id ");
	 * System.out.println("4) Fetch All Category (Alpabetical order) ");
	 * System.out.println("5) Update Category ");
	 * System.out.println("6) Delete Category "); System.out.println();
	 * System.out.println("6) Add New Brand ");
	 * System.out.println("7) Update Brand ");
	 * System.out.println("8) Fetch Brand By Category Name");
	 * System.out.println("9) Fetch Brand By Category Id ");
	 * System.out.println("10) Fetch Brand By Brand Id");
	 * System.out.println("11) Delete Brand By brand Id"); System.out.println();
	 * System.out.println("12) Add New Product");
	 * System.out.println("13) Update Product");
	 * System.out.println("14) Fetch All Product");
	 * System.out.println("15) Fetch All Product Based on Category Name");
	 * System.out.println("16) Fetch All Product Based on Brand Name");
	 * System.out.println("17) Fetch All Product Based on the Price Range");
	 * System.out.println("18) Fetch All Product Based on above the Price Range");
	 * System.out.println("19) Fetch All Product Based on below the Price Range");
	 * System.out.println("20) Delete Product ");
	 * System.out.println("21) Read Data From CSV File");
	 * System.out.println("\nEnter your choice  "); int ch =
	 * InputValidation.inputIntegerValidation();
	 * 
	 * Category category = new Category(); Brand brand = new Brand(); Product
	 * product = new Product();
	 * 
	 * switch (ch) { case 1: InputData.addNewCategory();
	 * System.out.println("You have selected \n1)Add New Category");
	 * System.out.println("Enter Category Name :: "); String categoryName =
	 * InputValidation.inputStringValidation();
	 * category.setCategoryName(categoryName); String msg =
	 * categoryDao.addNewCategory(category); System.out.println(msg +
	 * " Category Name :: " + category.getCategoryName()); break; case 2:
	 * System.out.println("You have selected \n 2)Find Category By Category Id");
	 * System.out.println("Enter category Id :: "); int catId =
	 * InputValidation.inputIntegerValidation(); Category existCat =
	 * categoryDao.findById(catId); System.out.println(existCat); break; case 3:
	 * System.out.println("You have selected \n 3)Fetch All Category");
	 * categoryDao.fetchAllCategories().forEach(System.out::println); break; case 4:
	 * System.out.println("You have selected \n 4)Update Category");
	 * System.out.println("Enter category Id "); int categoryId =
	 * InputValidation.inputIntegerValidation();
	 * System.out.println("Enter category Name "); String catName =
	 * InputValidation.inputStringValidation(); category.setCategoryId(categoryId);
	 * category.setCategoryName(catName); String message =
	 * categoryDao.updateCategory(category); System.out.println(message); break;
	 * case 5: System.out.println("You have selected \n 5)Delete Category");
	 * System.out.println("Enter category Id "); int catsId =
	 * InputValidation.inputIntegerValidation(); String deleteCatMessage =
	 * categoryDao.deleteCategoryId(catsId);
	 * 
	 * System.out.println(deleteCatMessage); break; case 6:
	 * System.out.println("You have selected \n 6)Add New Brand");
	 * System.out.println("Enter brand Name "); String brandName =
	 * InputValidation.inputStringValidation(); brand.setBrandName(brandName);
	 * 
	 * System.out.println("Enter category Id "); int cateId =
	 * InputValidation.inputIntegerValidation(); category.setCategoryId(cateId);
	 * 
	 * brand.setCategory(category); String newBrandAdded =
	 * brandDao.addNewBrand(brand); System.out.println(newBrandAdded); break; case
	 * 7: System.out.println("You have selected \n 7)Update Brand");
	 * 
	 * System.out.println("Enter brand Id "); int existingBrandId =
	 * InputValidation.inputIntegerValidation();
	 * 
	 * System.out.println("Enter brand name "); String newBrandName =
	 * InputValidation.inputStringValidation();
	 * 
	 * System.out.println("Enter category Id"); int newCatId =
	 * InputValidation.inputIntegerValidation(); category.setCategoryId(newCatId);
	 * 
	 * brand.setBrandId(existingBrandId); brand.setBrandName(newBrandName);
	 * brand.setCategory(category);
	 * 
	 * String updateBrand = brandDao.updatebrand(brand);
	 * System.out.println(updateBrand); break; case 8:
	 * System.out.println("You have selected \n 8)Fetch Brand By Category Name");
	 * System.out.println("Enter category name "); String fetchBrandbyCategoryname =
	 * InputValidation.inputStringValidation();
	 * brandDao.fetchBrandByCategoryName(fetchBrandbyCategoryname).forEach(System.
	 * out::println); break; case 9:
	 * System.out.println("You have selected \n 9)Fetch Brand By Category Id");
	 * System.out.println("Enter Category Id"); int catID =
	 * InputValidation.inputIntegerValidation();
	 * brandDao.fetchBrandByCategoryId(catID).forEach(System.out::println); break;
	 * case 10:
	 * System.out.println("You have selected \n 10)Fetch Brand By Brand Id");
	 * System.out.println("Enter Brand Id "); int brandId =
	 * InputValidation.inputIntegerValidation();
	 * System.out.println(brandDao.fetchBrandById(brandId)); break; case 11:
	 * System.out.println("You have selected \n 11)Delete Brand By brand Id");
	 * System.out.println("Enter brand Id"); int deleteBrandId =
	 * InputValidation.inputIntegerValidation();
	 * System.out.println(brandDao.deleteBrandById(deleteBrandId)); break; case 12:
	 * System.out.println("You have selected \n 12)Add New Product");
	 * System.out.println("Enter product Name"); String productName = sc.next();
	 * 
	 * System.out.println("Enter Product Price"); double price =
	 * InputValidation.inputDoubleValidation();
	 * 
	 * System.out.println("Enter product quantity"); int quantity =
	 * InputValidation.inputIntegerValidation();
	 * 
	 * System.out.println("Enter product description"); String description =
	 * sc.next();
	 * 
	 * System.out.println("Enter brand id "); int prodBrandId =
	 * InputValidation.inputIntegerValidation(); brand.setBrandId(prodBrandId);
	 * 
	 * System.out.println("Enter category id "); int prodCategoryId =
	 * InputValidation.inputIntegerValidation();
	 * category.setCategoryId(prodCategoryId);
	 * 
	 * product.setProductName(productName); product.setPrice(price);
	 * product.setQuantity(quantity); product.setDescription(description);
	 * product.setBrand(brand); product.setCategory(category);
	 * 
	 * System.out.println(productDao.addNewProduct(product)); break; case 13:
	 * System.out.println("You have selected \n 13)Update Product");
	 * 
	 * System.out.println("Enter Product Id"); int existingProductId =
	 * InputValidation.inputIntegerValidation();
	 * 
	 * System.out.println("Enter product Name"); String newProductName = sc.next();
	 * 
	 * System.out.println("Enter Product Price"); double newPrice =
	 * InputValidation.inputDoubleValidation();
	 * 
	 * System.out.println("Enter product quantity"); int newQuantity =
	 * InputValidation.inputIntegerValidation();
	 * 
	 * System.out.println("Enter product description"); String newQescription =
	 * sc.next();
	 * 
	 * System.out.println("Enter brand id "); int newProdBrandId =
	 * InputValidation.inputIntegerValidation(); brand.setBrandId(newProdBrandId);
	 * 
	 * System.out.println("Enter category id "); int newProdCategoryId =
	 * InputValidation.inputIntegerValidation();
	 * category.setCategoryId(newProdCategoryId);
	 * 
	 * product.setProductId(existingProductId);
	 * product.setProductName(newProductName); product.setPrice(newPrice);
	 * product.setQuantity(newQuantity); product.setDescription(newQescription);
	 * product.setBrand(brand); product.setCategory(category);
	 * System.out.println(productDao.updateProduct(product)); break; case 14:
	 * System.out.println("You have selected \n 14)Fetch All Products");
	 * productDao.fetchAll().forEach(System.out::println); break; case 15:
	 * System.out.
	 * println("You have selected \n 15)Fetch All Products Based on Category Name");
	 * System.out.println("Enter Category name"); String productCatName =
	 * InputValidation.inputStringValidation();
	 * 
	 * productDao.fetchProductByCategoryName(productCatName).forEach(System.out::
	 * println); break; case 16: System.out.
	 * println("You have selected \n 16)Fetch All Products Based on Brand Name");
	 * System.out.println("Enter Brand name"); String productBrandName =
	 * InputValidation.inputStringValidation();
	 * 
	 * productDao.fetchProductByBrandName(productBrandName).forEach(System.out::
	 * println); break; case 17: System.out.
	 * println("You have selected \n 17)Fetch All Product Based on the Price Range"
	 * ); System.out.println("Enter minium Price "); double minPrice =
	 * InputValidation.inputDoubleValidation();
	 * System.out.println("Enter maximun Price "); double maxPrice =
	 * InputValidation.inputDoubleValidation();
	 * productDao.fetchProductInBetweenPriceRange(minPrice,
	 * maxPrice).forEach(System.out::println); break; case 18: System.out.
	 * println("You have selected \n 18)Fetch All Product Based on the above the Price Range"
	 * ); System.out.println("Enter minium Price "); double abovePriceRange =
	 * InputValidation.inputDoubleValidation();
	 * productDao.fetchProductAboveThePriceRange(abovePriceRange).forEach(System.out
	 * ::println); break; case 19: System.out.
	 * println("You have selected \n 19)Fetch All Product Based on the below the Price Range"
	 * ); System.out.println("Enter minium Price "); double belowPriceRange =
	 * InputValidation.inputDoubleValidation();
	 * productDao.fetchProductBelowThePriceRange(belowPriceRange).forEach(System.out
	 * ::println); break; case 20:
	 * System.out.println("You have selected \n 20)Delete Product ");
	 * System.out.println("Enter Product Id"); int existProductId =
	 * InputValidation.inputIntegerValidation();
	 * System.out.println(productDao.deleteProduct(existProductId)); break;
	 * 
	 * default: System.out.println("Please enter available choice number !!!");
	 * System.out.println("========================================"); }
	 * 
	 * System.out.println("Do you Want To continue ? \n1) yes 2) no"); num =
	 * InputValidation.inputIntegerValidation();
	 * 
	 * } while (num == 1); }
	 */
}
