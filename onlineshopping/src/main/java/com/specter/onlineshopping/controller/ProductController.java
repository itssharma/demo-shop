package com.specter.onlineshopping.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.specter.onlineshopping.dao.categoryDAO;
import com.specter.onlineshopping.dao.productDAO;
import com.specter.onlineshopping.entity.Category;
import com.specter.onlineshopping.entity.Product;
import com.specter.onlineshopping.validator.ProductValidator;

@Controller
public class ProductController {

	@Autowired
	public productDAO productdao;
	
	@Autowired
	public categoryDAO categorydao;
	
	private static String uploadfolder = "E://demo_projects//temp//";
	
	//view individual product
	@GetMapping("/show/product/{productid}")
	public ModelAndView showproduct(@PathVariable("productid") int id) {
		ModelAndView mav = new ModelAndView("home");
		Product product = null;
		product = productdao.getproduct(id);
		mav.addObject("title", product.getName());
		mav.addObject("userClickProduct", true);
		mav.addObject("product", product);
		return mav;
	}
	
	//view manage products admin page
	@GetMapping("/manage/products")
	public ModelAndView manageproducts(@RequestParam(name="operation", required = false) String operation) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("title", "Manage Products");
		mav.addObject("userClickManageProduct",true);
		
		if(operation!=null) {
				if(operation.equals("added")) {
				mav.addObject("message", "Product added successfully");
			}
		}
		
		Product theproduct = new Product();
		theproduct.setActive(true);
		theproduct.setSupplierId(1);
		mav.addObject("product", theproduct);
		return mav;
	}
	
	//get categories model attribute
	@ModelAttribute("categories")
	public List<Category> getcategories(){
		return categorydao.listCategories();
	}
	
	//edit products
	//view manage products admin page
		@GetMapping("/manage/products/{productid}")
		public ModelAndView manageeditproducts(@PathVariable("productid") int pid) {
			ModelAndView mav = new ModelAndView("home");
			mav.addObject("title", "Manage Products");
			mav.addObject("userClickManageProduct",true);

			
			Product theproduct = productdao.getproduct(pid);
			mav.addObject("product", theproduct);
			return mav;
		}
		
	//add product
		@PostMapping("/manage/products/add")
		public String addproducts(@Valid @ModelAttribute("product") Product theproduct, BindingResult bindingresults,
				Model model) {
			if (theproduct.getId() == 0) {
				ProductValidator pv = new ProductValidator();
				pv.validate(theproduct, bindingresults);
			} else {
				if (!theproduct.getFile().getOriginalFilename().equals("")) {
					ProductValidator pv = new ProductValidator();
					pv.validate(theproduct, bindingresults);
				}
			}

			if (bindingresults.hasErrors()) {
				model.addAttribute("title", "Manage Products");
				model.addAttribute("userClickManageProduct", true);
				return "home";
			}

			try {
				byte[] bytes = theproduct.getFile().getBytes();
				Path path = Paths.get(uploadfolder + theproduct.getFile().getOriginalFilename());
				Files.write(path, bytes);
			} catch (IOException e) {
				// TODO Auto-generated
				e.printStackTrace();
			}

			productdao.addproduct(theproduct);
			model.addAttribute("operation", "added");
			return "redirect:/manage/products?operation=added";
		}
}
