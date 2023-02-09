package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductsRepository;

@Service
public class ProductsDataService implements DataAccessInterface<ProductEntity> {
	/*
	 * autowiring enables injection of an object dependency implicitly internally
	 * uses a constructor injection cannot be used to injection primitive & string
	 * values
	 */
	@Autowired
	private ProductsRepository productsRepository;

	/*
	 * Provides JavaBean framework provides a type data can access to it in the form
	 * of input streams & output streams Non-default constructor for constructor
	 * injection
	 */
	public ProductsDataService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	/**
	 * CRUD to return all entities
	 */

	@Override
	public ProductEntity getGameId(long id) {
		// TODO Auto-generated method stub

		return productsRepository.findById(id).orElse(null);
	}

	@Override
	public List<ProductEntity> getAllGames() {
		List<ProductEntity> games = (List<ProductEntity>) productsRepository.findAll();
		return games;
	}

	@Override
	public long addGame(ProductEntity model) {
		// TODO Auto-generated method stub
		ProductEntity outcome = productsRepository.save(model);
		if (outcome == null) {
			return 0;
		}
		return outcome.getId();
	}

	@Override
	public boolean deleteGame(long id) {
		// TODO Auto-generated method stub
		productsRepository.deleteById(id);
		return true;
	}

	@Override
	public ProductEntity editGame(long id, ProductEntity editGame) {
		// TODO Auto-generated method stub
		ProductEntity game = productsRepository.save(editGame);
		return game;
	}

	public List<ProductEntity> searchByGameName(String searchTerm) {
		// TODO Auto-generated method stub
		List<ProductEntity> game = productsRepository.findByGameNameContainingIgnoreCase(searchTerm);
		return game;
	}

}
