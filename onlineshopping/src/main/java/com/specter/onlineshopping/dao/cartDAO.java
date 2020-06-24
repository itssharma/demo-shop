package com.specter.onlineshopping.dao;

import java.util.List;

import com.specter.onlineshopping.entity.Cart_Items;
import com.specter.onlineshopping.entity.Product;

public interface cartDAO {

	public List<Cart_Items> showAllCartItems();

	public void addproduct(Product product);

}
