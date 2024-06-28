package com.ronaldo.prueba.service.impl;

import com.ronaldo.prueba.model.Cuenta;
import com.ronaldo.prueba.model.Movimiento;
import com.ronaldo.prueba.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaService cuentaService;

    @Transactional
    public Movimiento registrarMovimiento(Movimiento movimiento, Long cuentaId) {
        Optional<Cuenta> cuentaOptional = cuentaService.obtenerCuenta(cuentaId);
        if (!cuentaOptional.isPresent()) {
            throw new RuntimeException("Cuenta no encontrada");
        }

        Cuenta cuenta = cuentaOptional.get();
        double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();
        if (nuevoSaldo < 0) {
            throw new RuntimeException("Saldo no disponible");
        }

        movimiento.setSaldo(nuevoSaldo);
        movimiento.setCuenta(cuenta);
        cuenta.setSaldoInicial(nuevoSaldo);

        cuentaService.actualizarCuenta(cuenta.getId(), cuenta);
        return movimientoRepository.save(movimiento);
    }

    public List<Movimiento> obtenerMovimientosPorCuenta(Long cuentaId) {
        return movimientoRepository.findAllByCuentaId(cuentaId);
    }
}
