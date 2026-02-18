package com.thawanlc.cpfinancas.mapper;

import com.thawanlc.cpfinancas.dto.DespesaResponse;
import com.thawanlc.cpfinancas.dto.UsuarioResponse;
import com.thawanlc.cpfinancas.entity.Financa;
import com.thawanlc.cpfinancas.entity.Usuario;

public class DespesaMapper {
    
    public static DespesaResponse toResponse(Financa f) {
        return new DespesaResponse(
            f.getId(),
            f.getDescricao(),
            f.getValor(),
            f.getTipoDespesa(),
            f.getDataHora()
        );
    }

    public static UsuarioResponse toUsuarioResponse(Usuario u) {
        return new UsuarioResponse(
            u.getId(),
            u.getNome(),
            u.getEmail()
        );
    }

}
