package com.devRenan01.corse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devRenan01.corse.entities.Order;
import com.devRenan01.corse.repositories.OrderRepository;

@Service 
public class OrderService {
	// Operação para buscar o usuário pelo Id;
	
	@Autowired
	private OrderRepository repository;
	
	// Operação para buscar todos os uários do banco de dados
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order finfById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
