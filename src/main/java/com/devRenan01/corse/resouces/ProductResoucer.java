package com.devRenan01.corse.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devRenan01.corse.entities.Product;
import com.devRenan01.corse.services.ProductService;

@RestController
// Informar que a classe é um recurso web implementando um controladosr REST

@RequestMapping(value = "/products")
// Dar nome ao recurso
public class ProductResoucer {
	
	@Autowired
	private ProductService service;	
	
	
	// controlador rest que responde no caminho "/users"
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){	
		
		List<Product> list =  service.findAll();
		return ResponseEntity.ok().body(list);// Resposta de sucesso http
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> finfById(@PathVariable Long id){
		Product obj = service.finfById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	
	
}
