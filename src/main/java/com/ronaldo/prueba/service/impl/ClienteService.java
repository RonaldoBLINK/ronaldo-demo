package com.ronaldo.prueba.service.impl;

import com.ronaldo.prueba.model.Cliente;
import com.ronaldo.prueba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente actualizarCliente(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }
}
