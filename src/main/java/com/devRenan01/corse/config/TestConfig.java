package com.devRenan01.corse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devRenan01.corse.entities.Order;
import com.devRenan01.corse.entities.User;
import com.devRenan01.corse.repositories.OrderRepository;
import com.devRenan01.corse.repositories.UserRepository;

// Informar ao Spring que essa classe é uma classe especifica de configuração
@Configuration

// Para informar que essa classe ela vai ser uma configuração especifica para o perfil de test 
@Profile("test")//identificar o spring que só vai rodar essa configuração somente quando estiver no perfil de test

public class TestConfig implements CommandLineRunner {
	// interface que permite executar código antes do início de uma aplicação
	
	
	/*para que o spring consiga resolver a dependencia e instanciar uma instancia do "userRepository" no "testConfig"
	  basta cologar a anotação.*/
	@Autowired
	private UserRepository userRepository;// obj que acessa os dados

	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// Tudo que for colocado desse metodo será executado quando a aplicação for iniciada
		User u1 = new User(null, "Renan", "renan@gmail.com", "911111111", "12345");	
		User u2 = new User(null, "Souza", "souza@gmail.com", "922222222", "12345");	
		
		Order o1 = new Order(null, Instant.parse("2025-03-27T14:03:54Z"), u1);
		Order o2 = new Order(null, Instant.parse("2025-04-28T14:05:44Z"), u2);
		Order o3 = new Order(null, Instant.parse("2025-04-29T14:03:21Z"), u1);

		//salvar os obj no banco de dados.
		userRepository.saveAll(Arrays.asList(u1, u2));
		//comando "saveAll" -> passa uma lista de obj e salva no banco de dados
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}
	
}
