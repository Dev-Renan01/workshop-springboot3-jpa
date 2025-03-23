package com.devRenan01.corse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devRenan01.corse.entities.User;
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

	@Override
	public void run(String... args) throws Exception {
		// Tudo que for colocado desse metodo será executado quando a aplicação for iniciada
		User u1 = new User(null, "Renan", "renan@gmail.com", "911111111", "12345");	
		User u2 = new User(null, "Souza", "souza@gmail.com", "922222222", "12345");	
		
		//salvar os obj no banco de dados.
		userRepository.saveAll(Arrays.asList(u1, u2));
		//comando "saveAll" -> passa uma lista de obj e salva no banco de dados
	}
	
}
