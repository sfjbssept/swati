package com.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController("/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("addproduct")
	Integer addProduct(@RequestBody Product product) {
		Integer id = productService.addProduct(product);
		return id;
		
	}
	
	@GetMapping("allproducts")
	List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	

}
