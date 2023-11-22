package com.api_senai.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_senai.api.entities.Conta;
import com.api_senai.api.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> getAllcontas(){
        List<Conta> contas = contaRepository.findAll();

        return contas;
    }
    public Conta getContaById(Long id){

        Conta conta = contaRepository.findById(id).orElse(null);

        return conta;
    }
    public Conta  saveConta (Conta novaConta){

        Conta conta = contaRepository.save(novaConta);
        return conta;
    }
    public Conta updateConta(Long id, Conta contaAtualizada){
        
        Conta contaExistente = getContaById(id);
        contaExistente.setAllAtributos(contaAtualizada);
        saveConta(contaExistente);

        return contaExistente;
    }
    public Conta updateConta2(Long id, Conta contaAtualizado){
        
        Conta contaExistente = getContaById(id);
        contaExistente.setAllAtributosMapping(contaAtualizado);
        saveConta(contaExistente);
        
        return contaExistente;
    }
   
    public Conta deleteConta(Long id){

        contaRepository.deleteById(id);
        Conta contaDeletada = getContaById(id);

        return contaDeletada;
    }
    public Conta logicalDeleteConta(Long id){
        Conta contaExistente = getContaById(id);
        contaExistente.setAtivo(false);
        saveConta(contaExistente);

        return contaExistente;
    }
    public List<Conta> getAllContas() {
        return null;
    }
    public Conta getContasByid(Long id) {
        return null;
    }
    public Conta getContaByid(Long id) {
        return null;
    }  
    
    
}
