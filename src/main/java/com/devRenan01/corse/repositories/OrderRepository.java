package com.devRenan01.corse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devRenan01.corse.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
