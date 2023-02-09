package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductModel;

public interface ProductBusinessServiceInterface {
	public void test();

	// CRUD Stuff
	public ProductModel getGameId(long id);

	// Adding a game
	public long addGame(ProductModel model);

	// Deleting a Game
	public boolean deleteGame(long id);

	// Editing a Game
	public ProductModel editGame(long id, ProductModel editGame);

	// Getting the list of games
	public List<ProductModel> getAllGames();

	// Searching for game by Name
	public List<ProductModel> searchByGameName(String searchTerm);

	// Test for starting and finishing the app

	public void init();

	public void destroy();

}
