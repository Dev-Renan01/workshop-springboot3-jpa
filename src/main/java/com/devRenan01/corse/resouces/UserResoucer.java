package com.devRenan01.corse.resouces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devRenan01.corse.entities.User;

@RestController
// Informar que a classe é um recurso web implementando um controladosr REST

@RequestMapping(value = "/users")
// Dar nome ao recurso
public class UserResoucer {
	
	// controlador rest que responde no caminho "/users"
	@GetMapping
	public ResponseEntity<User> findAll(){ 
		// tipo especifico do spring para retornar respostas de requisições web
		User u = new User(null, "thiago", "thiago@gmail.com", "81928739","1234");
		return ResponseEntity.ok().body(u);
	}
}
