package com.thawanlc.cpfinancas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thawanlc.cpfinancas.dto.UsuarioRequest;
import com.thawanlc.cpfinancas.dto.UsuarioResponse;
import com.thawanlc.cpfinancas.entity.Usuario;
import com.thawanlc.cpfinancas.mapper.DespesaMapper;
import com.thawanlc.cpfinancas.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponse salvarUsuario(@Valid UsuarioRequest dto) {
        
        Usuario u = new Usuario();
        u.setNome(dto.nome());
        u.setEmail(dto.email());

        usuarioRepository.saveAndFlush(u);

        return DespesaMapper.toUsuarioResponse(u);
    }

    public UsuarioResponse buscarUsuarioPorId(Long id) {
        Usuario u = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return DespesaMapper.toUsuarioResponse(u);
        
    }

     public UsuarioResponse deletarUsuario(Long id) {
        Usuario u = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioRepository.delete(u);
        return DespesaMapper.toUsuarioResponse(u);
     }

     public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
     }

}
