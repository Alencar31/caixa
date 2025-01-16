package com.controle.caixa.service;

import com.controle.caixa.data.SaldoEntity;
import com.controle.caixa.data.SaldoRepository;
import com.controle.caixa.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaldoService {
    
    @Autowired
    SaldoRepository saldoRepository; 
    
    public SaldoEntity criarSaldo(SaldoEntity saldo) {
        saldo.setId(null);
        saldoRepository.save(saldo);
        return saldo;
    }
    
    public SaldoEntity atualizarSaldo(Integer saldoId, SaldoEntity saldoRequest) {
        SaldoEntity saldo = getSaldoId(saldoId);
        saldo.setContaId(saldoRequest.getContaId());
        saldo.setSaldoAtual(saldoRequest.getSaldoAtual());        
        saldoRepository.save(saldo);
        return saldo;
    }
    
    public SaldoEntity getSaldoId(Integer saldoId) {
        return saldoRepository.findById(saldoId).orElseThrow(() -> new ResourceNotFoundException("Saldo não encontrado!" + saldoId));
    }
    
    public List<SaldoEntity> listarTodosSaldos() {
        return saldoRepository.findAll();
    }
    
    public void inativarSaldo(Integer saldoId) {
        SaldoEntity saldo = getSaldoId(saldoId);
        saldo.setStatus(false);        
        saldoRepository.save(saldo);
    }
}