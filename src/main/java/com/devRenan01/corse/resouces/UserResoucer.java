package com.devRenan01.corse.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devRenan01.corse.entities.User;
import com.devRenan01.corse.services.UserService;

@RestController
// Informar que a classe é um recurso web implementando um controladosr REST

@RequestMapping(value = "/users")
// Dar nome ao recurso
public class UserResoucer {
	
	@Autowired
	private UserService service;	
	
	
	// controlador rest que responde no caminho "/users"
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list =  service.findAll();
		return ResponseEntity.ok().body(list);// Resposta de sucesso http
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> finfById(@PathVariable Long id){
		User obj = service.finfById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	
	
}
