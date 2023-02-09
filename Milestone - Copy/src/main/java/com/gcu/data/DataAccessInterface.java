package com.gcu.data;

import java.util.List;

import com.gcu.data.entity.ProductEntity;

//<T> is a place holder for the model(parameter data type)
//<t> is the placeholder for the parameter name
public interface DataAccessInterface<T> {

	public T getGameId(long id);

	public long addGame(T model);

	public boolean deleteGame(long id);

	public T editGame(long id, T editGame);

	public List<ProductEntity> getAllGames();
}
