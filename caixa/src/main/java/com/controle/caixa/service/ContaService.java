package com.controle.caixa.service;

import com.controle.caixa.data.ContaEntity;
import com.controle.caixa.data.ContaRepository;
import com.controle.caixa.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    
    @Autowired
    ContaRepository contaRepository; 
    
    public ContaEntity criarConta(ContaEntity conta) {
        conta.setId(null);
        contaRepository.save(conta);
        return conta;
    }
    
    public ContaEntity atualizarConta(Integer contaId, ContaEntity contaRequest) {
        ContaEntity conta = getContaId(contaId);
        conta.setDescricao(contaRequest.getDescricao());
        conta.setNatureza(contaRequest.getNatureza());
        conta.setPrincipal(contaRequest.getPrincipal());
        contaRepository.save(conta);
        return conta;
    }
    
    public ContaEntity getContaId(Integer contaId) {
        return contaRepository.findById(contaId).orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada " + contaId));
    }
    
    public List<ContaEntity> listarTodasContas() {
        return contaRepository.findAll();
    }
    
    public void inativarConta(Integer contaId) {
        ContaEntity conta = getContaId(contaId);
        conta.setStatus(false);        
        contaRepository.save(conta);
    }
    
    public List<ContaEntity> getContaPorDescricao(String descricao) {
        return contaRepository.findByDescricaoContaining(descricao);
    }
}