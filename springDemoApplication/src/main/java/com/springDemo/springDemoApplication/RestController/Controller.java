package com.springDemo.springDemoApplication.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springDemo.springDemoApplication.Entity.ProductInfo;
import com.springDemo.springDemoApplication.Service.Service;

// REST Controller is used to handle browser requests

@RestController		// handles various requests - mappings
@RequestMapping("/products")	// browser request url
public class Controller {
	
	// Create the instance of service to fetch the previously difined user functions to use throughout the code
	@Autowired		// Establishes connection and instantiates the object 
	private Service service;
	
	// insert
	@PostMapping
	// @requestBody annotation is used to read the object from request url 
	public ResponseEntity<ProductInfo> insertProduct(@RequestBody ProductInfo info) {
		ProductInfo insert =  service.insertProduct(info);
		return new ResponseEntity<>(insert, HttpStatus.CREATED);
	}
	
	// select all
	@GetMapping
	public List<ProductInfo> getProducts() {
		// findAll() method returns all records of porvided type
		return service.getProducts();
	}
	
	// select particular
	@GetMapping("/{id}")	// if request encounters along with id; it means single record needs to be fetched
	// To read the id from request url @pathVariable annotation is used
	public ResponseEntity<ProductInfo> getProduct(@PathVariable Long id) {
		ProductInfo info = service.getProduct(id);
		
		if(info != null) {
			return new ResponseEntity<>(info, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		// deleteById() - deletes records for provided id
		service.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
