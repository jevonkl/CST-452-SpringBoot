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
public class TestController {
	/**
	 * This function routes from / to the actual index page
	 * 
	 * @return
	 */
	@GetMapping("/test")
	public String display() {
		return "test";
	}

}