package com.springDemo.springDemoApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springDemo.springDemoApplication.Entity.ProductInfo;
import com.springDemo.springDemoApplication.Repository.JPARepository;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired	// Dependency Injection
	private JPARepository repository;
	
	// create
	public ProductInfo insertProduct( ProductInfo info ) {
		// save() method saves the entity
		return repository.save(info) ;
	}
	
	// select all
	public List<ProductInfo> getProducts() {
		// findAll() method returns all records of provided type
		return repository.findAll();
	}
	
	// select particular
	public ProductInfo getProduct(Long id) {
		// findById() - takes id as a parameter and provides row with respect to id
		return repository.findById(id).orElse(null);
	}
	
	// update
	public ProductInfo updateProduct(Long id, ProductInfo updatedInfo) {
		// To update we always fetch the existing details first 
		// Here the findById() method fetch us all the records of particular id
		// Store results directly into object of Entity
		ProductInfo existingInfo = repository.findById(id).orElse(null);
		
		// If records for provided id exists we will update results
		if(existingInfo != null) {
			existingInfo.setTitle(updatedInfo.getTitle());
			existingInfo.setDescription(updatedInfo.getDescription());
			existingInfo.setPrice(updatedInfo.getPrice());
			return repository.save(existingInfo);
		}
		// else return null 
		return null;
	}

	// delete
	public Boolean deleteProduct(Long id) {
		// deleteById() - deletes records for provided id
		Optional<ProductInfo> productOptional = repository.findById(id);
		
		if(productOptional.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
}
