package com.ronaldo.prueba.repository;

import com.ronaldo.prueba.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
