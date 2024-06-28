package com.ronaldo.prueba.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente extends Persona{

    @Column(unique = true, nullable = false)
    private String clienteId;

    private String contraseña;
    private String estado;
}
