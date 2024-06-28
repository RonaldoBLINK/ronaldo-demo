package com.ronaldo.prueba.repository;

import com.ronaldo.prueba.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findAllByCuentaId(Long cuentaId);
}
