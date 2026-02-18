package com.thawanlc.cpfinancas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.thawanlc.cpfinancas.entity.Financa;

public interface DespesaRepository extends JpaRepository<Financa, Long> {
    
}
