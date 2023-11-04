package com.api_senai.api.controller;

import com.api_senai.api.entities.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<funcionario>> getAllFuncionarios(){
        
        List<funcionario> funcionarios = funcionarioService.getAllFuncionarios();

        return ResponseEntity.ok(funcionarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id){
        
        Funcionario funcionario = funcionarioService.getFuncionarioById(id);

        if (funcionario != null){
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping
    public ResponseEntity<Funcionario> savefuncionario(@RequestBody Funcionario novoFuncionario){

        Funcionario funcionario = funcionarioService.savefuncionario(novofuncionario);
        return ResponseEntity.ok(funcionario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario (@RequestBody  funcionario funcionarioAtualizado, @PathVariable Long id) {

        Funcionario funcionario = funcionarioService.updateFuncionario(id, funcionarioAtualizado);
        return ResponseEntity.ok(funcionario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable Long id){

        Funcionario funcionario = funcionarioService.deleteFuncionario(id);
        
        return ResponseEntity.ok(funcionario);
    }

}
