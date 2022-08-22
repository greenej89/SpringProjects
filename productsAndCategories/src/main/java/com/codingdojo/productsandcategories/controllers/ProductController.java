package com.codingdojo.productsandcategories.controllers;

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

import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.AppService;

@Controller
public class ProductController {
	@Autowired
	private AppService appService;
	
	//Create
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "products/new.jsp";
	}
	
	@PostMapping("/products")
	public String createProduct(@Valid @ModelAttribute("product") Product product, 
								BindingResult result) {
		if(result.hasErrors()) {
			return "products/new.jsp";
		}
		appService.saveProduct(product);
		return "redirect:/products/" + product.getId();
	}
	
	//Read
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = appService.findProductById(id);		
		model.addAttribute("product", product);
		//return a list of categories to which the product does not belong
		model.addAttribute("categoryOptions", appService.getCategoryOptionsByProduct(product));
		return "products/show.jsp";
	}
	
	//Associations
	@PostMapping("/categorize/{id}")
	public String categorize(@PathVariable Long id, @RequestParam Long categoryId) {
		appService.categorizeProduct(id, categoryId);
		return "redirect:/products/" + id;
	}
	
}
