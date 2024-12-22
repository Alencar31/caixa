package com.controle.caixa.controller;

import com.controle.caixa.data.HistoricoEntity;
import com.controle.caixa.service.HistoricoService;
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
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    HistoricoService historicoService;    

    @GetMapping("/listarTodosHistoricos")
    public ResponseEntity<List> getAllHistoricos() {
        List<HistoricoEntity> historicos = historicoService.listarTodosHistoricos();
        return new ResponseEntity<>(historicos, HttpStatus.OK);
    }
    
    @GetMapping("/pesquisarHistorico/{id}")
    public ResponseEntity<HistoricoEntity> getHistoricoById(@PathVariable Integer id) {
        HistoricoEntity historico = historicoService.getHistoricoId(id);
        return new ResponseEntity<>(historico, HttpStatus.OK);
    }
    
    @PostMapping("/adicionarHistorico")
    public ResponseEntity<HistoricoEntity> addHistorico(@RequestBody HistoricoEntity historico) {
        var novoHistorico = historicoService.criarHistorico(historico);
        return new ResponseEntity<>(novoHistorico, HttpStatus.CREATED);
    }
    
    @PutMapping("/atualizarHistorico/{id}")
    public ResponseEntity<HistoricoEntity> atualizarHistorico(@PathVariable Integer id, @RequestBody HistoricoEntity historico) {
        var historicoAtualizado = historicoService.atualizarHistorico(id, historico);
        return new ResponseEntity<>(historicoAtualizado, HttpStatus.OK);
    }
    
    @PutMapping("/inativarHistorico/{id}")
    public ResponseEntity inativarHistorico(@PathVariable Integer id) {
        historicoService.inativarHistorico(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }      
}
