package com.ronaldo.prueba.service.impl;

import com.ronaldo.prueba.model.Cuenta;
import com.ronaldo.prueba.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> obtenerCuenta(Long id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta actualizarCuenta(Long id, Cuenta cuenta) {
        cuenta.setId(id);
        return cuentaRepository.save(cuenta);
    }

    public void eliminarCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }

    public List<Cuenta> obtenerTodasLasCuentas() {
        return cuentaRepository.findAll();
    }
}
