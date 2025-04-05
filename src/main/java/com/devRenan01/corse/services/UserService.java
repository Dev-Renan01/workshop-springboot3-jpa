package com.devRenan01.corse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devRenan01.corse.entities.User;
import com.devRenan01.corse.repositories.UserRepository;

@Service 
public class UserService {
	// Operação para buscar o usuário pelo Id;
	
	@Autowired
	private UserRepository repository;
	
	// Operação para buscar todos os uários do banco de dados
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User finfById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	public User insert(User obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
