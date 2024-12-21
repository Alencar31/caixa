package com.controle.caixa.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Integer>{
    ContaEntity findByDescricao(String descricao);
    List<ContaEntity> findByDescricaoStartingWith(String descricao);
    List<ContaEntity> findByDescricaoEndingWith(String descricao);
    List<ContaEntity> findByDescricaoContaining(String descricao);
    List<ContaEntity> findByOrderByDescricaoAsc();
    List<ContaEntity> findByOrderByDescricaoDesc();
}
