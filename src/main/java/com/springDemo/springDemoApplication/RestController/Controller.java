package com.springDemo.springDemoApplication.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<String> insertProduct(@RequestBody ProductInfo info) {
		service.insertProduct(info);
		String successMessage = "Data successfully processed..!";
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	// select all
	@GetMapping
	public List<ProductInfo> getProducts() {
		// findAll() method returns all records of provided type
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
	
	// Update
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductInfo info) {
		ProductInfo updateProduct = service.updateProduct(id, info);
		
		if(updateProduct != null) {
			return new ResponseEntity<>("Product with id "+id+" Updated succesfully..!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Product with id "+id+" not found..!", HttpStatus.NOT_FOUND);
		}
		
		
		
		
		
		
		
	}
	
	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		
		// store the value if exists
		boolean isDeleted = service.deleteProduct(id);
		
		if(isDeleted) {
			String successMessage = "Data successfully deleted..!";
			return new ResponseEntity<String>(successMessage, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Product with ID "+ id +" not found.", HttpStatus.NOT_FOUND);
		}
	}
}
