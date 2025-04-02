package com.devRenan01.corse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devRenan01.corse.entities.Category;
import com.devRenan01.corse.repositories.CategoryRepository;

@Service 
public class CategoryService {
	// Operação para buscar o usuário pelo Id;
	
	@Autowired
	private CategoryRepository repository;
	
	// Operação para buscar todos os uários do banco de dados
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category finfById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get()	;
	}
	
}
