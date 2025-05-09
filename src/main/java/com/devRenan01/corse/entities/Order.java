package com.devRenan01.corse.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.devRenan01.corse.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T' HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment; // Registrar um "Instant", melhor que o "Date";

	private Integer orderStatus;

	@ManyToOne
	// Comandos JPA / Transformar em uma chave estrangeira
	@JoinColumn(name = "client_id") // Informar o nome da chave estrangeira do banco de dados
	private User client;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;

	// Construtores
	public Order() {

	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	// Getter e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();

		}

	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	

	public Set<OrderItem> getItems() {
		return items;
	}

	public Double getTotal() {
		double soma = 0;
		for(OrderItem x : items) {
			soma = x.getSubTotal();
		}
		return soma;
	}
	
	// Hashcode e Equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
