package com.specter.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class testJspController {
	
	@GetMapping(value= {"/", "home", "index"})
	public ModelAndView jspTestController() {
		ModelAndView mav = new ModelAndView("testjsp");
		mav.addObject("name", "ayush sharma hun mai");
		return mav;
	}
}
