package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * Index controller calls display() when routed to /
 * 
 */
@Controller
@RequestMapping("/")
public class IndexController {
	/**
	 * This function routes from / to the actual index page
	 * 
	 * @return
	 */
	@GetMapping("/")
	public String display() {
		return "index";
	}

}