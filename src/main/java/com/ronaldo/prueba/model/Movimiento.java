package com.ronaldo.prueba.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    private String tipoMovimiento;
    private double valor;
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;
}
