package com.devRenan01.corse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devRenan01.corse.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
