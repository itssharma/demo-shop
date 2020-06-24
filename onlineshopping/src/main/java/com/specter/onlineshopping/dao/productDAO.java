package com.specter.onlineshopping.dao;

import com.specter.onlineshopping.entity.Product;

public interface productDAO {

	public Product getproduct(int id);

	public void addproduct(Product theproduct);



}
