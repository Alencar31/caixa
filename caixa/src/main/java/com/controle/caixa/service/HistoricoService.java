package com.controle.caixa.service;

import com.controle.caixa.data.HistoricoEntity;
import com.controle.caixa.data.HistoricoRepository;
import com.controle.caixa.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService {
    
    @Autowired
    HistoricoRepository historicoRepository; 
    
    public HistoricoEntity criarHistorico(HistoricoEntity historico) {
        historico.setId(null);
        historico.setStatus(true);
        historicoRepository.save(historico);
        return historico;
    }
    
    public HistoricoEntity atualizarHistorico(Integer historicoId, HistoricoEntity historicoRequest) {
        HistoricoEntity historico = getHistoricoId(historicoId);
        historico.setDescricao(historicoRequest.getDescricao());
        historico.setComplemento(historicoRequest.getComplemento());
        historicoRepository.save(historico);
        return historico;
    }
    
    public HistoricoEntity getHistoricoId(Integer historicoId) {
        return historicoRepository.findById(historicoId).orElseThrow(() -> new ResourceNotFoundException("Histórico não encontrado!" + historicoId));
    }
    
    public List<HistoricoEntity> listarTodosHistoricos() {
        return historicoRepository.findAll();
    }
    
    public void inativarHistorico(Integer historicoId) {
        HistoricoEntity historico = getHistoricoId(historicoId);
        historico.setStatus(false);        
        historicoRepository.save(historico);
    }
    
    public List<HistoricoEntity> getHistoricoPorDescricao(String descricao) {
        return historicoRepository.findByDescricaoContaining(descricao);
    }
}
