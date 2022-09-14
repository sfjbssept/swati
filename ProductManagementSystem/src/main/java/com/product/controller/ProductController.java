package com.product.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
	
	@GetMapping("product/{id}")
	Optional<Product> getProduct(@PathVariable Integer id) {
		Optional<Product> product = productService.getProduct(id);
		return product;
		
	}
	
	@PutMapping("update/{Id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("Id") Integer Id,@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product, Id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("del/{Id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable Integer Id){
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			productService.deleteProduct(Id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
