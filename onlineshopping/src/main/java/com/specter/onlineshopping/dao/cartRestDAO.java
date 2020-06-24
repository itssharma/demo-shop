package com.specter.onlineshopping.dao;

import java.util.List;

import com.specter.onlineshopping.entity.Cart_Items;

public interface cartRestDAO {

	List<Cart_Items> listAllCartItems();

}