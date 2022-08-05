package com.codingdojo.helloworld.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@RequestMapping("/welcome")
	public String welcome(HttpSession session) {
		session.setAttribute("userName", "Jessica");
		return "welcome.jsp";
	}
}
