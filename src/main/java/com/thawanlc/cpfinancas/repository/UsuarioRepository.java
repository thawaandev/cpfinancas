package com.thawanlc.cpfinancas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thawanlc.cpfinancas.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
