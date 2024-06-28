package com.ronaldo.prueba.controller;

import com.ronaldo.prueba.model.Cuenta;
import com.ronaldo.prueba.service.impl.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        Cuenta nuevaCuenta = cuentaService.crearCuenta(cuenta);
        return ResponseEntity.ok(nuevaCuenta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerCuenta(@PathVariable Long id) {
        Optional<Cuenta> cuenta = cuentaService.obtenerCuenta(id);
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        Cuenta cuentaActualizada = cuentaService.actualizarCuenta(id, cuenta);
        return ResponseEntity.ok(cuentaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Cuenta>> obtenerTodasLasCuentas() {
        List<Cuenta> cuentas = cuentaService.obtenerTodasLasCuentas();
        return ResponseEntity.ok(cuentas);
    }
}
