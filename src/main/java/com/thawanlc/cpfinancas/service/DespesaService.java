package com.thawanlc.cpfinancas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thawanlc.cpfinancas.dto.DespesaCreateRequest;
import com.thawanlc.cpfinancas.dto.DespesaResponse;
import com.thawanlc.cpfinancas.entity.Financa;
import com.thawanlc.cpfinancas.entity.Usuario;
import com.thawanlc.cpfinancas.exceptions.RecursoNaoEncontrado;
import com.thawanlc.cpfinancas.mapper.DespesaMapper;
import com.thawanlc.cpfinancas.repository.DespesaRepository;
import com.thawanlc.cpfinancas.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class DespesaService {
    
    private final DespesaRepository despesaRepository;
    private final UsuarioRepository usuarioRepository;

    public DespesaService(DespesaRepository despesaRepository, UsuarioRepository usuarioRepository) {
        this.despesaRepository = despesaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public DespesaResponse salvarDespesa(@Valid DespesaCreateRequest dto) {

        Usuario u = usuarioRepository.findById(dto.usuarioId())
            .orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado"));


        Financa f = new Financa();
        f.setDescricao(dto.descricao());
        f.setValor(dto.valor());
        f.setTipoDespesa(dto.tipoDespesa());
        f.setUsuario(u);
        f.setDataHora(LocalDateTime.now());

        despesaRepository.saveAndFlush(f);

        return DespesaMapper.toResponse(f);
    }

    public DespesaResponse buscarDespesaPorId(Long id) {
        Financa f = despesaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));

        return DespesaMapper.toResponse(f);
    }

    public DespesaResponse deletarDespesa(Long id) {
        Financa f = despesaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));

        despesaRepository.delete(f);
        return DespesaMapper.toResponse(f);
    }

    public List<Financa> listarTodos() {
        return despesaRepository.findAll();
    }

}
