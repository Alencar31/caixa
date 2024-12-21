package com.controle.caixa.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<HistoricoEntity, Integer>{
    HistoricoEntity findByDescricao(String descricao);
    List<HistoricoEntity> findByDescricaoStartingWith(String descricao);
    List<HistoricoEntity> findByDescricaoEndingWith(String descricao);
    List<HistoricoEntity> findByDescricaoContaining(String descricao);
    List<HistoricoEntity> findByOrderByDescricaoAsc();
    List<HistoricoEntity> findByOrderByDescricaoDesc(); 
}