package com.specter.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.specter.onlineshopping.dao.cartRestDAO;
import com.specter.onlineshopping.entity.Cart_Items;

@RestController
@RequestMapping("/api")
public class CartRestController {

	@Autowired
	private cartRestDAO thecartrestdao;
	
	@GetMapping("/cartitems/show")
	public List<Cart_Items> showCartItems() {
		return thecartrestdao.listAllCartItems();
	}
	
}
