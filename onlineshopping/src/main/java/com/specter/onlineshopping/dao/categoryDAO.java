package com.specter.onlineshopping.dao;

import java.util.List;

import com.specter.onlineshopping.entity.Category;

public interface categoryDAO {
	public List<Category> listCategories();

	public Category listCategoryProducts(int cat_id);

	public List<Category> listAllActiveCategories();

}
