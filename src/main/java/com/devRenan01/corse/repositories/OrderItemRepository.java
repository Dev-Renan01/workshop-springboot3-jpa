package com.devRenan01.corse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devRenan01.corse.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, com.devRenan01.corse.entities.pk.OrderItemPk> {

}
