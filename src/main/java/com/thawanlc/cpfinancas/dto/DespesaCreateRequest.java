package com.thawanlc.cpfinancas.dto;

import com.thawanlc.cpfinancas.entity.enums.TipoDespesa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DespesaCreateRequest(
    @NotBlank @Size(max = 80) String descricao,
    @NotNull Double valor,
    @NotNull TipoDespesa tipoDespesa,
    @NotNull Long usuarioId
) {
    
}
