package com.devRenan01.corse.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devRenan01.corse.entities.Category;
import com.devRenan01.corse.entities.Order;
import com.devRenan01.corse.services.CategoryService;

@RestController
// Informar que a classe é um recurso web implementando um controladosr REST

@RequestMapping(value = "/categories")
// Dar nome ao recurso
public class CategoryResoucer {
	
	@Autowired
	private CategoryService service;	
	
	
	// controlador rest que responde no caminho "/users"
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){	
		
		List<Category> list =  service.findAll();
		return ResponseEntity.ok().body(list);// Resposta de sucesso http
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Category> finfById(@PathVariable Long id){
		Category obj = service.finfById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	
	
}
