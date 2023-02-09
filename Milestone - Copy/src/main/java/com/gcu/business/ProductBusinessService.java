package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductsDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

public class ProductBusinessService implements ProductBusinessServiceInterface {

	@Autowired
	ProductsDataService service;

	@Override
	public ProductModel getGameId(long id) {

		ProductEntity entity = service.getGameId(id);
		ProductModel game = new ProductModel(entity.getId(), entity.getGameNo(), entity.getGameName(),
				entity.getPrice(), entity.getQuantity());
		return game;
	}

	@Override
	public long addGame(ProductModel model) {
		// TODO Auto-generated method stub
		ProductEntity entity = new ProductEntity(model.getGameId(), model.getGameNo(), model.getGameName(),
				model.getPrice(), model.getQuantity());
		return service.addGame(entity);
	}

	@Override
	public boolean deleteGame(long id) {
		// TODO Auto-generated method stub
		return service.deleteGame(id);
	}

	@Override
	public ProductModel editGame(long id, ProductModel editGame) {
		// TODO Auto-generated method stub
		ProductEntity entity = new ProductEntity(editGame.getGameId(), editGame.getGameNo(), editGame.getGameName(),
				editGame.getPrice(), editGame.getQuantity());
		ProductEntity outcome = service.editGame(id, entity);

		ProductModel edited = new ProductModel(outcome.getId(), outcome.getGameNo(), outcome.getGameName(),
				outcome.getPrice(), outcome.getQuantity());

		return edited;
	}

	@Override
	public List<ProductModel> searchByGameName(String searchTerm) {
		// TODO Auto-generated method stub
		// List for entity
		List<ProductEntity> pe = service.searchByGameName(searchTerm);
		// makes a new list for the games
		List<ProductModel> games = new ArrayList<ProductModel>();
		for (ProductEntity ent : pe) {
			games.add(new ProductModel(ent.getId(), ent.getGameNo(), ent.getGameName(), ent.getPrice(),
					ent.getQuantity()));
		}
		return games;
	}

	@Override
	public void init() {
		System.out.println("In the OrdersBusinessService.init()");
	}

	@Override
	public void destroy() {
		System.out.println("In the OrdersBusinessService.destroy()");
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductModel> getAllGames() {
		// TODO Auto-generated method stub
		// entity list
		List<ProductEntity> gamesE = service.getAllGames();
		// shifts it to to list
		List<ProductModel> games = new ArrayList<ProductModel>();
		for (ProductEntity entity : gamesE) {
			games.add(new ProductModel(entity.getId(), entity.getGameNo(), entity.getGameName(), entity.getPrice(),
					entity.getQuantity()));
		}
		return games;
	}

}
