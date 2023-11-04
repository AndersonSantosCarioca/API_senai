package com.api_senai.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_senai.api.entities.Cliente;
import com.api_senai.api.service.FuncionarioService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private FuncionarioService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        
        List<Cliente> clientes = clienteService.getAllClientes();

        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientesById(@PathVariable Long id){
        
        Cliente cliente = clienteService.getClienteById(id);

        if (cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente novoCliente){

        Cliente cliente = clienteService.saveCliente(novoCliente);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente (@RequestBody Cliente clienteAtualizado, @PathVariable Long id) {

        Cliente cliente = clienteService.updateCliente(id, clienteAtualizado);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){

        Cliente cliente = clienteService.deleteCliente(id);
        
        return ResponseEntity.ok(cliente);
    }

}
