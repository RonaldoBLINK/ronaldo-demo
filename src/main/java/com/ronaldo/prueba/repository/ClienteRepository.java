package com.ronaldo.prueba.repository;

import com.ronaldo.prueba.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
