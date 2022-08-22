package com.codingdojo.productsandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.productsandcategories.services.AppService;

@Controller
public class HomeController {
	@Autowired
	private AppService appService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", appService.allProducts());
		model.addAttribute("categories", appService.allCategories());
		return "index.jsp";
	}
}
