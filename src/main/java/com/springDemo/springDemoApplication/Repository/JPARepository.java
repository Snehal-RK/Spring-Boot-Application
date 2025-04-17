package com.springDemo.springDemoApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springDemo.springDemoApplication.Entity.ProductInfo;

// This interface receives two parameters < ClassName, DatatypeOfIdentity >
public interface JPARepository extends JpaRepository<ProductInfo, Long> {
	
}
