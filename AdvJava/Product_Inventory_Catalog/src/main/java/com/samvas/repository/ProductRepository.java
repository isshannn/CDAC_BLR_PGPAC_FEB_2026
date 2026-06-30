package com.samvas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samvas.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	// Inherits complete CRUD operations automatically (findAll, save, deleteById, etc.)
}
