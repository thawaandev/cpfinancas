package com.thawanlc.cpfinancas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
    @NotBlank @Size(max = 25) String nome, 
    @NotBlank @Size(max = 100) String email) {
    
}
