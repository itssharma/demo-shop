package com.specter.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.specter.onlineshopping.dao.cartDAO;
import com.specter.onlineshopping.dao.productDAO;
import com.specter.onlineshopping.entity.Product;

@Controller
@RequestMapping("/cart")
public class CartController {

	
	  private cartDAO thecartdao;
	  
	  @Autowired 
	  public CartController(cartDAO cartdao) { 
		  thecartdao = cartdao; 
	  }
	  
		/*
		 * @Autowired public categoryDAO categorydao;
		 * 
		 * //get categories model attribute
		 * 
		 * @ModelAttribute("categories") public List<Category> getcategories(){ return
		 * categorydao.listCategories(); }
		 */
	
	@Autowired
	private productDAO productdao;
	
	//show cartitems
	@GetMapping("/show")
	public ModelAndView showCartItems() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("title", "My Cart");
		mav.addObject("userClickShowCart", "true");
		//mav.addObject("thecategories", categories);
		
		return mav;
	}
	
	
	  //add cartitems
	
	  @PostMapping("/add/{cart_id}") 
	  public String addCartItems(@PathVariable("cart_id") int cart_id, Model model) {
		  Product product = null;
		  product = productdao.getproduct(cart_id);
		  //thecartdao.addproduct(product);
	  return "redirect:/show/all/products?operation=added"; }
	 
}
