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

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.services.AppService;

@Controller
public class CategoryController {
	@Autowired
	private AppService appService;
	
	//Create
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("/categories")
	public String createCategory(@Valid @ModelAttribute("category") Category category,
								BindingResult result) {
		if(result.hasErrors()) {
			return "categories/new.jsp";
		}
		appService.saveCategory(category);
		return "redirect:/categories/" + category.getId();
	}
	
	//Read
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = appService.findCategoryById(id);
		model.addAttribute("category", category);
		model.addAttribute("productOptions", appService.getProductsNotInCategory(category));
		return "categories/show.jsp";
	}
}
