package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.LoginModel;

/**
 * routes from /login to the login.html file
 *
 */
@Controller
public class LoginController {

	@GetMapping("/login")
	public String display(Model model) {

		model.addAttribute("title", "Login Form");
		return "login";
	}

	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		// Points User to the loginSuccess page after successfully registering a user
		model.addAttribute("title", "Login Success");
		return "loginSuccess";
	}
}
