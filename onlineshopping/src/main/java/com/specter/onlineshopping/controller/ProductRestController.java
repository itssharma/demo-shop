package com.specter.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.specter.onlineshopping.dao.productRestDAO;
//import com.specter.onlineshopping.entity.Category;
import com.specter.onlineshopping.entity.Product;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	private productRestDAO productrestdao;
	
	@Autowired
	public ProductRestController(productRestDAO theproductrestdao) {
		this.productrestdao = theproductrestdao;
	}
	
	//get all products
	@GetMapping("/products")
	public List<Product> getallactiveproducts() {
		return productrestdao.listAllActiveproducts();
	}
	
	//get all products by selected category
	@GetMapping("/category/{categoryid}/products")
	public List<Product> getallactiveproductsbycategory(@PathVariable("categoryid") int categoryId){
		
		return productrestdao.listAllActiveproductsbycategory(categoryId);
	}
	
	@GetMapping("/manage/products")
	public List<Product> getallproducts() {
		return productrestdao.listproducts();
	}
	
	//get all products by selected category
	@GetMapping("/manage/category/{categoryid}/products")
	public List<Product> getallproductsbycategory(@PathVariable("categoryid") int categoryId){
		
		return productrestdao.listproductsbycategory(categoryId);
	}
}
