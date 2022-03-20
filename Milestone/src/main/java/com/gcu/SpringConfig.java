package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.ProductBusinessService;
import com.gcu.business.ProductBusinessServiceInterface;

@Configuration
public class SpringConfig {

	@Bean(name = "productsBusinessService", initMethod = "init", destroyMethod = "destroy")

	public ProductBusinessServiceInterface getProductBusiness() {
		return new ProductBusinessService();
	}
}
