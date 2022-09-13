package com.product.service;

import java.util.List;

import com.product.entity.Product;

public interface ProductService {
	
	Integer addProduct(Product product);
	List<Product> getAllProducts();

}
