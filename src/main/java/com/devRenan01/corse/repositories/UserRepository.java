package com.devRenan01.corse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devRenan01.corse.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
