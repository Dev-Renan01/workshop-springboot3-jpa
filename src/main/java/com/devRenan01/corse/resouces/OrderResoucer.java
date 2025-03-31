package com.devRenan01.corse.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devRenan01.corse.entities.Order;
import com.devRenan01.corse.entities.User;
import com.devRenan01.corse.services.OrderService;

@RestController
// Informar que a classe é um recurso web implementando um controladosr REST

@RequestMapping(value = "/Order")
// Dar nome ao recurso
public class OrderResoucer {
	
	@Autowired
	private OrderService service;	
	
	
	// controlador rest que responde no caminho "/users"
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){	
		
		List<Order> list =  service.findAll();
		return ResponseEntity.ok().body(list);// Resposta de sucesso http
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> finfById(@PathVariable Long id){
		Order obj = service.finfById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	
	
}
