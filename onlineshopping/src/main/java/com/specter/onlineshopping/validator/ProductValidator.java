package com.specter.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.specter.onlineshopping.entity.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object theproduct, Errors errors) {
		
		Product product = (Product) theproduct;
		
		if(product.getFile() == null 
				|| product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please upload valid file");
			return;
		}
	}

}
