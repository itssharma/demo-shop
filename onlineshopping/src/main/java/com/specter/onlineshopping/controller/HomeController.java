package com.specter.onlineshopping.controller;

import java.util.List;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.specter.onlineshopping.dao.categoryDAO;
import com.specter.onlineshopping.entity.Category;

@Controller
public class HomeController {

	//private static final Logger mylogger = LoggerFactory.getLogger(HomeController.class);
	
	private categoryDAO thecategorydao;

	@Autowired
	public HomeController(categoryDAO categorydao) {
		thecategorydao = categorydao;
	}

	// home view
	
//	@GetMapping("/login")
//    public ModelAndView login() {
//		ModelAndView mav = new ModelAndView("login");
//        return mav;
//    }
	
	@GetMapping(value = { "/", "home", "index" })
	public ModelAndView home() {
		
		/*
		 * mylogger.info("inside home"); mylogger.debug("inside home");
		 * mylogger.trace("inside home"); mylogger.warn("inside home");
		 * mylogger.error("inside home");
		 */
		ModelAndView mav = new ModelAndView("home");
		List<Category> thecategory = null;
		thecategory = thecategorydao.listAllActiveCategories();
		mav.addObject("title", "Home");
		mav.addObject("userClickHome", true);
		mav.addObject("allcategories", thecategory);
		return mav;
	}

	// about view
	
	@GetMapping("/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("title", "About");
		mav.addObject("userClickAbout", true);
		return mav;
	}

	// contact view
	@GetMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("title", "Contact");
		mav.addObject("userClickContact", true);
		return mav;
	}

	// get all products view
	@GetMapping("/show/all/products")
	public ModelAndView showAllProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mav = new ModelAndView("home");
		if(operation!=null) {
			if(operation == "added") {
				mav.addObject("message", "Added to cart");
			}
		}
		mav.addObject("title", "ALL PRODUCTS");
		mav.addObject("userClickAllProducts", true);
		mav.addObject("allcategories", thecategorydao.listAllActiveCategories());
		return mav;
	}

	// get category based products view
	@GetMapping("/show/category/{categoryId}/products")
	public ModelAndView showCategoryProducts(@PathVariable("categoryId") int cat_id) {

		Category thecategory = null;
		thecategory = thecategorydao.listCategoryProducts(cat_id);

		ModelAndView mav = new ModelAndView("home");
		mav.addObject("title", thecategory.getName());
		mav.addObject("allcategories", thecategorydao.listAllActiveCategories());
		mav.addObject("userClickCategoryProducts", true);
		mav.addObject("category", thecategory);
		return mav;
	}
}
