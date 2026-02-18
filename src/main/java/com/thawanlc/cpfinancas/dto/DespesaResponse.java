package com.thawanlc.cpfinancas.dto;


import java.time.LocalDateTime;

import com.thawanlc.cpfinancas.entity.enums.TipoDespesa;

public record DespesaResponse(
    Long id,
    String descricao,
    Double valor,
    TipoDespesa tipoDespesa,
    LocalDateTime dataHora
) {
    
}
