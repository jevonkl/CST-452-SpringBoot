package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductModel;

public interface ProductBusinessServiceInterface {
	public void test();

	public ProductModel getGameId(long id);

	public long addGame(ProductModel model);

	public boolean deleteGame(long id);

	public ProductModel editGame(long id, ProductModel editGame);

	public List<ProductModel> getAllGames();

	// Test for starting and finishing the app

	public void init();

	public void destroy();

}
