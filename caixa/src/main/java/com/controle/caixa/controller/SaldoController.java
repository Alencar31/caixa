package com.controle.caixa.controller;

import com.controle.caixa.data.SaldoEntity;
import com.controle.caixa.service.SaldoService;
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
@RequestMapping("/saldo")
public class SaldoController {

    @Autowired
    SaldoService saldoService;    

    @GetMapping("/listarTodosSaldos")
    public ResponseEntity<List> getAllSaldos() {
        List<SaldoEntity> saldos = saldoService.listarTodosSaldos();
        return new ResponseEntity<>(saldos, HttpStatus.OK);
    }
    
    @PostMapping("/adicionarSaldo")
    public ResponseEntity<SaldoEntity> addSaldo(@RequestBody SaldoEntity saldo) {
        var novoSaldo = saldoService.criarSaldo(saldo);
        return new ResponseEntity<>(novoSaldo, HttpStatus.CREATED);
    }
    
    @PutMapping("/atualizarSaldo/{id}")
    public ResponseEntity<SaldoEntity> atualizarSaldo(@PathVariable Integer id, @RequestBody SaldoEntity saldo) {
        var saldoAtualizado = saldoService.atualizarSaldo(id, saldo);
        return new ResponseEntity<>(saldoAtualizado, HttpStatus.OK);
    }
}