package com.controle.caixa.data;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Integer>{
    ContaEntity findByDescricao(String descricao);
    List<ContaEntity> findByDescricaoStartingWith(String descricao);
    List<ContaEntity> findByDescricaoEndingWith(String descricao);
    List<ContaEntity> findByDescricaoContaining(String descricao);
    List<ContaEntity> findByOrderByDescricaoAsc();
    List<ContaEntity> findByOrderByDescricaoDesc();
}
