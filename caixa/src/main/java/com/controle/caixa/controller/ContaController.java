package com.controle.caixa.controller;

import com.controle.caixa.data.ContaEntity;
import com.controle.caixa.service.ContaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping("/listarTodasContas")
    public ResponseEntity<List> getAllContas() {
        List<ContaEntity> contas = contaService.listarTodasContas();
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisarConta/{id}")
    public ResponseEntity<ContaEntity> getContaById(@PathVariable Integer id) {
        ContaEntity conta = contaService.getContaId(id);
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }
    
    @PostMapping("/adicionarConta")
    public ResponseEntity<ContaEntity> addConta(@RequestBody ContaEntity conta) {
        var novaConta = contaService.criarConta(conta);
        return new ResponseEntity<>(novaConta, HttpStatus.CREATED);
    }
    
    @PutMapping("/atualizarConta/{id}")
    public ResponseEntity<ContaEntity> atualizarConta(@PathVariable Integer id, @RequestBody ContaEntity conta) {
        var contaAtualizada = contaService.atualizarConta(id, conta);
        return new ResponseEntity<>(contaAtualizada, HttpStatus.OK);
    }
    
    @PutMapping("/inativarConta/{id}")
    public ResponseEntity inativarConta(@PathVariable Integer id) {
        contaService.inativarConta(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }       
}