package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.ProductEntity;

public interface ProductsRepository extends CrudRepository<ProductEntity, Long> {

	List<ProductEntity> findByGameNameContainingIgnoreCase(String searchTerm);

}
