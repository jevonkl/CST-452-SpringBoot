package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.RegisterModel;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@GetMapping("/")
	public String display(Model model) {

		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}

	@PostMapping("/doRegister")
	public String doRegister(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
		// Outputs items to the console
		System.out.println(String.format("User registered. Username : %s and Password: %s", registerModel.getUsername(),
				registerModel.getPassword()));

		// Checks if the inputed registerModel meets the requirements of it's
		// validation

		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Re-Register");
			return "register";
		}

		// Points User to the loginSuccess page after successfully registering a user
		model.addAttribute("title", "Register Success");
		return "loginSuccess";
	}

}