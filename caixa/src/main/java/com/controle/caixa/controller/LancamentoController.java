package com.controle.caixa.controller;

import com.controle.caixa.data.LancamentoEntity;
import com.controle.caixa.service.LancamentoService;
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
@RequestMapping("/lancamento")
public class LancamentoController {

    @Autowired
    LancamentoService lancamentoService;    

    @GetMapping("/listarTodosLancamentos")
    public ResponseEntity<List> getAllLancamentos() {
        List<LancamentoEntity> lancamentos = lancamentoService.listarTodosLancamentos();
        return new ResponseEntity<>(lancamentos, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisarLancamento/{id}")
    public ResponseEntity<LancamentoEntity> getLancamentoById(@PathVariable Integer id) {
        LancamentoEntity lancamento = lancamentoService.getLancamentoId(id);
        return new ResponseEntity<>(lancamento, HttpStatus.OK);
    }
    
    @PostMapping("/adicionarLancamento")
    public ResponseEntity<LancamentoEntity> addLancamento(@RequestBody LancamentoEntity lancamento) {
        var novoLancamento = lancamentoService.criarLancamento(lancamento);
        return new ResponseEntity<>(novoLancamento, HttpStatus.CREATED);
    }
    
    @PutMapping("/atualizarLancamento/{id}")
    public ResponseEntity<LancamentoEntity> atualizarLancamento(@PathVariable Integer id, @RequestBody LancamentoEntity lancamento) {
        var lancamentoAtualizado = lancamentoService.atualizarLancamento(id, lancamento);
        return new ResponseEntity<>(lancamentoAtualizado, HttpStatus.OK);
    }
    
    @PutMapping("/inativarLancamento/{id}")
    public ResponseEntity inativarLancamento(@PathVariable Integer id) {
        lancamentoService.inativarLancamento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }      
}