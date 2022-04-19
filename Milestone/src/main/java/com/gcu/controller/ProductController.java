package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.gcu.business.ProductBusinessServiceInterface;
import com.gcu.model.ProductModel;
import com.gcu.model.SearchModel;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductBusinessServiceInterface service;

	// This is for the standard games
	@GetMapping("/game")
	public String newGame(Model model) {

		model.addAttribute("title", "Game");
		model.addAttribute("productModel", new ProductModel());
		return "game";
	}

	// This is to show the edit game function
	@GetMapping("/editGame")
	public String updateGameDisplay(ProductModel productModel, Model model) {
		System.out.println(productModel.toString());
		model.addAttribute("title", "Edit Game");
		model.addAttribute("productModel", productModel);
		return "editGame";
	}

	// GameGuy displays the games in the table
	@GetMapping("/gameGuy")
	public String GameView(Model model) {
		List<ProductModel> products = service.getAllGames();
		model.addAttribute("title", "Game Guy");
		model.addAttribute("products", products);
		return "gameGuy";
	}

	// This is for the search function of the site
	@GetMapping("/searchGames")
	public String searchProductDisplay(Model model) {
		model.addAttribute("title", "Search for Games");
		model.addAttribute("searchModel", new SearchModel());
		return "searchGames";
	}

	// This is the post mapping for adding the game to the site
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

	// This is the edit postmapping for editing the game
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

	// This is the post mapping for deleting the game
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

	// This is the search function post mapping for searching games by name
	@PostMapping("/searchGameName")
	public String searchByGameTitle(@Valid SearchModel searchModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Search for Games");
			return "searchGames";
		}
		List<ProductModel> products = service.searchByGameName(searchModel.getSearchTerm());
		model.addAttribute("title", "Search for a Game by Title");
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("products", products);
		return "searchResults";
	}

	// This is the restAPI function for getting the games added afterwards
	@GetMapping("/getGames")
	public String getGames(Model model) {
		String hostname = "localhost";
		// port 8082 for the REstAPi
		int port = 8082;
		// URL Address
		String url = "http://" + hostname + ":" + port + "/service/gameGuy";
		// For REST template
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ProductModel>> rateResponse = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ProductModel>>() {
				});
		List<ProductModel> games = rateResponse.getBody();

		model.addAttribute("title", "List of Games");
		model.addAttribute("games", games);
		return "gameGuy";
	}

}
