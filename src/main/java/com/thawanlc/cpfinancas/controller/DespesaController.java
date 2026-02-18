package com.thawanlc.cpfinancas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thawanlc.cpfinancas.dto.DespesaCreateRequest;
import com.thawanlc.cpfinancas.dto.DespesaResponse;
import com.thawanlc.cpfinancas.entity.Financa;
import com.thawanlc.cpfinancas.service.DespesaService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/despesas")
public class DespesaController {
    
    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarDespesa(@Valid @RequestBody DespesaCreateRequest request) {
        despesaService.salvarDespesa(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDespesa(@PathVariable Long id) {
        despesaService.deletarDespesa(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public DespesaResponse listarDespesa(@PathVariable Long id) {
        return despesaService.buscarDespesaPorId(id);
    }

    @GetMapping
    public List<Financa> listAll() {
        return despesaService.listarTodos();
    }
    
    

}
