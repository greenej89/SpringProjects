package com.codingdojo.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.services.LicenseService;
import com.codingdojo.relationships.services.PersonService;

@Controller
public class LicenseController {
	
	@Autowired
	LicenseService licenseService;
	
	@Autowired
	PersonService personService;

	//create
	@GetMapping("/licenses/new")
	public String index(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("allPersons", personService.findAllPersons());
//		model.addAttribute("unlicensedPersons", personService.findPersonsWithoutLicense());  //filtering query
		model.addAttribute("newLicenseNumber", licenseService.getNextLicenseId());
		return "newLicense.jsp";
	}
	@PostMapping("/licenses/create")
	public String licenses(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allPersons", personService.findAllPersons());
//			model.addAttribute("unlicensedPersons", personService.findPersonsWithoutLicense()); //filtering query
			model.addAttribute("newLicenseNumber", licenseService.getNextLicenseId());
			return "newLicense.jsp"; 
		} else {
			license.setNumber(license.getState() + license.getNumber());
		    licenseService.createLicense(license);
			Long personId = license.getPerson().getId();
			return String.format("redirect:/persons/%d", personId);
		}
	}
}
