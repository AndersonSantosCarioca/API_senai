package com.api_senai.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_senai.api.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
