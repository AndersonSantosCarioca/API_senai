package com.api_senai.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_senai.api.entities.Cliente;
import com.api_senai.api.repository.ClienteRepository;

@Service
public class FuncionarioService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();

        return clientes;
    }
    public Cliente getClienteById(Long id){

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        return cliente;
    }
    public Cliente saveCliente(Cliente novoCliente){

        Cliente cliente = clienteRepository.save(novoCliente);
        return cliente;
    }
    public Cliente updateCliente(Long id, Cliente clienteAtualizado){

        Cliente cliente = saveCliente(clienteAtualizado);

        return cliente;
    }
    public Cliente deleteCliente(Long id){

        Cliente cliente = getClienteById(id);
        clienteRepository.deleteById(id);
        Cliente clienteDeletado = getClienteById(id);

        return clienteDeletado;
    }
}
