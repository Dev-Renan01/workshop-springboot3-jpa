package com.devRenan01.corse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devRenan01.corse.entities.Category;
import com.devRenan01.corse.entities.Order;
import com.devRenan01.corse.entities.OrderItem;
import com.devRenan01.corse.entities.Product;
import com.devRenan01.corse.entities.User;
import com.devRenan01.corse.entities.enums.OrderStatus;
import com.devRenan01.corse.repositories.CategoryRepository;
import com.devRenan01.corse.repositories.OrderItemRepository;
import com.devRenan01.corse.repositories.OrderRepository;
import com.devRenan01.corse.repositories.ProductRepository;
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
	
	@Autowired	
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository; 
	
	@Override
	public void run(String... args) throws Exception {
		// Tudo que for colocado desse metodo será executado quando a aplicação for iniciada
	
		Category cat1 = new Category(null, "Eletroncs");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computer");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		// Salvar novamente os produtos com as associações realizadas

		
		
		User u1 = new User(null, "Renan", "renan@gmail.com", "911111111", "12345");	
		User u2 = new User(null, "Souza", "souza@gmail.com", "922222222", "12345");	
		
		Order o1 = new Order(null, Instant.parse("2025-03-27T14:03:54Z"),OrderStatus.PAID , u1);
		Order o2 = new Order(null, Instant.parse("2025-04-28T14:05:44Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2025-04-29T14:03:21Z"),OrderStatus.WAITING_PAYMENT , u1);

		//salvar os obj no banco de dados.
		//comando "saveAll" -> passa uma lista de obj e salva no banco de dados

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}
	
}
