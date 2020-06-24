/**
 * 
 */
package com.specter.onlineshopping.dao;

import java.util.List;

import com.specter.onlineshopping.entity.Product;

/**
 * @author A
 *
 */
public interface productRestDAO {

	public List<Product> listproducts();

	public List<Product> listproductsbycategory(int categoryId);

	public List<Product> listAllActiveproducts();

	public List<Product> listAllActiveproductsbycategory(int categoryId);
}
