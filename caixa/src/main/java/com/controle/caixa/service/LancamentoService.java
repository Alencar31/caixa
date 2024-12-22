package com.controle.caixa.service;

import com.controle.caixa.data.LancamentoEntity;
import com.controle.caixa.data.LancamentoRepository;
import com.controle.caixa.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {
    
    @Autowired
    LancamentoRepository lancamentoRepository; 
    
    public LancamentoEntity criarLancamento(LancamentoEntity lancamento) {
        lancamento.setId(null);
        lancamentoRepository.save(lancamento);
        return lancamento;
    }
    
    public LancamentoEntity atualizarLancamento(Integer lancamentoId, LancamentoEntity lancamentoRequest) {
        LancamentoEntity lancamento = getLancamentoId(lancamentoId);
        lancamento.setContaId(lancamentoRequest.getContaId());
        lancamento.setValor(lancamentoRequest.getValor());
        lancamento.setDebcre(lancamentoRequest.getDebcre());
        lancamento.setHistoricoId(lancamentoRequest.getHistoricoId());
        lancamento.setComplemento(lancamentoRequest.getComplemento());     
        lancamentoRepository.save(lancamento);
        return lancamento;
    }
    
    public LancamentoEntity getLancamentoId(Integer lancamentoId) {
        return lancamentoRepository.findById(lancamentoId).orElseThrow(() -> new ResourceNotFoundException("Lancamento não encontrado!" + lancamentoId));
    }
    
    public List<LancamentoEntity> listarTodosLancamentos() {
        return lancamentoRepository.findAll();
    }
    
    public void inativarLancamento(Integer lancamentoId) {
        LancamentoEntity lancamento = getLancamentoId(lancamentoId);
        lancamento.setStatus(false);        
        lancamentoRepository.save(lancamento);
    }
}