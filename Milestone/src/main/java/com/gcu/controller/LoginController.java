package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;

/**
 * routes from /login to the login.html file
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ProductBusinessServiceInterface service;

	@Autowired
	private SecurityBusinessService security;

	/**
	 * 
	 * @param model
	 * @return route to login file
	 */
	@GetMapping("/")
	public String display(Model model) {

		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}

	/**
	 * Method called by button on index.html that checks user credentials for access
	 * to loginSuccess.html
	 * 
	 * @param loginModel
	 * @param bindingResult
	 * @param model
	 * @return routes to login or loginSuccess depending on whether the login was
	 *         successful
	 */
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

		// Checks if the inputted loginModel meets the requirements of it's validation
		if (bindingResult.hasErrors()) {
			System.out.println(
					String.format("Failed Login with %s, %s", loginModel.getUsername(), loginModel.getPassword()));
			model.addAttribute("title", "Failed Login");
			return "login";
		} else {
			// Outputs items to the console (for debugging)
			System.out.println(String.format("Login Call with Username of %s and Password of %s",
					loginModel.getUsername(), loginModel.getPassword()));

		}

		service.test();

		if (security.authenticate(loginModel)) {
			model.addAttribute("title", "Login Success");
			return "loginSuccess";
		} else {
			System.out.println("Failed Login, that user doesn't exist");
			return "login";
		}
	}

}