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

import com.api_senai.api.entities.Conta;
import com.api_senai.api.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> getAllContas(){

        List<Conta> contas = contaService.getAllContas();

        if(!contas.isEmpty()){
            return new ResponseEntity<>(contas, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(contas,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContasByid(@PathVariable Long id){

        Conta conta = contaService.getContasByid(id);

        if(conta != null){
            return new ResponseEntity<>(conta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(conta, HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping
    public ResponseEntity<Conta> saveConta(@RequestBody Conta novaConta){

        Conta conta = contaService.saveConta(novaConta);
        return ResponseEntity.ok(conta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@RequestBody Conta contaAtualizada,@PathVariable Long id){

        Conta conta = contaService.getContaByid(id);
        if(conta != null){
            Conta contaNova = contaService.updateConta(id, contaAtualizada);
            return new ResponseEntity<>(contaNova, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(conta, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/mapping/{id}")
    public ResponseEntity<Conta> updateContaMapping (@RequestBody Conta contaAtualizada, @PathVariable Long id){

        Conta conta = contaService.getContaByid(id);
        if(conta != null){
            Conta contaNova = contaService.updateConta(id, contaAtualizada);
            return new ResponseEntity<>(contaNova,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(conta, HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> deleteConta(@PathVariable Long id){

        Conta conta = contaService.getContaByid(id);

        if(conta != null){
            contaService.deleteConta(id);
            return new ResponseEntity<>(conta,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(conta, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Conta> logicalDeleteConta(@PathVariable Long id){

        Conta conta = contaService.getContaByid(id);

        if(conta != null){
            contaService.logicalDeleteConta(id);
            return new ResponseEntity<Conta>(conta,HttpStatus.OK);
        }else{
            return new ResponseEntity<Conta>(conta, HttpStatus.NOT_FOUND);
        }
    }
}
