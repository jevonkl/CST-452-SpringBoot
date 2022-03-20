package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductBusinessServiceInterface;
import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductBusinessServiceInterface service;

	@GetMapping("/game")
	public String newGame(Model model) {

		model.addAttribute("title", "Game");
		model.addAttribute("productModel", new ProductModel());
		return "game";
	}

	@GetMapping("/editGame")
	public String updateGameDisplay(ProductModel productModel, Model model) {
		System.out.println(productModel.toString());
		model.addAttribute("title", "Edit Game");
		model.addAttribute("productModel", productModel);
		return "editGame";
	}

	@GetMapping("/gameGuy")
	public String GameView(Model model) {
		List<ProductModel> products = service.getAllGames();
		model.addAttribute("title", "Game Guy");
		model.addAttribute("products", products);
		return "gameGuy";
	}

	@PostMapping("/addGame")
	public String addGame(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "New Game");
			return "game";
		}
		if (service.addGame(productModel) > 0) {
			model.addAttribute("productModel", productModel);
			return "gameSuccess";
		} else {
			return "game";
		}
	}

	@PostMapping("/doGameEdit")
	public String updateGame(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Game Guy");
			return "gameGuy";
		}
		service.editGame(productModel.getGameId(), productModel);
		List<ProductModel> products = service.getAllGames();
		model.addAttribute("title", "Game Guy");
		model.addAttribute("products", products);
		return "gameGuy";
	}

	@PostMapping("/deleteGame")
	public String deleteGame(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "New Game");
			return "gameGuy";
		}
		service.deleteGame(productModel.getGameId());
		List<ProductModel> products = service.getAllGames();
		model.addAttribute("title", "Game Guy");
		model.addAttribute("products", products);
		return "gameGuy";
	}

}
