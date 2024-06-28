package com.ronaldo.prueba.controller;

import com.ronaldo.prueba.model.Movimiento;
import com.ronaldo.prueba.service.impl.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<Movimiento> registrarMovimiento(@RequestBody Movimiento movimiento, @RequestParam Long cuentaId) {
        try {
            Movimiento nuevoMovimiento = movimientoService.registrarMovimiento(movimiento, cuentaId);
            return ResponseEntity.ok(nuevoMovimiento);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> obtenerMovimientosPorCuenta(@RequestParam Long cuentaId) {
        List<Movimiento> movimientos = movimientoService.obtenerMovimientosPorCuenta(cuentaId);
        return ResponseEntity.ok(movimientos);
    }
}
