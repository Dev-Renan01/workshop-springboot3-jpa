package com.devRenan01.corse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devRenan01.corse.entities.Product;
import com.devRenan01.corse.repositories.ProductRepository;

@Service 
public class ProductService {
	// Operação para buscar o usuário pelo Id;
	
	@Autowired
	private ProductRepository repository;
	
	// Operação para buscar todos os uários do banco de dados
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product finfById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
