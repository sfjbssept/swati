package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.entity.Product;

public interface ProductService {
	
	Integer addProduct(Product product);
	
	List<Product> getAllProducts();
	
	Optional<Product> getProduct(Integer id);
	
	Product updateProduct(Product product, Integer Id);
	
	void deleteProduct(Integer id);

}
