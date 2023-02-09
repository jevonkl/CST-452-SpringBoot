package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * Index controller calls display() when routed to /
 * 
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "My Index");
		return "index";
	}

}