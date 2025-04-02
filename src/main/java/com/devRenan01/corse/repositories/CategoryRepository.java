package com.devRenan01.corse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devRenan01.corse.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
