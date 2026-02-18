package com.thawanlc.cpfinancas.entity.enums;


public enum TipoDespesa {
    ALIMENTACAO,
    TRANSPORTE,
    MORADIA,
    SAUDE,
    LAZER,
    EDUCACAO,
    OUTROS;

    public static TipoDespesa fromString(String tipo) {
        if(tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Tipo de despesa não pode ser nulo");
        }
        for (TipoDespesa t : TipoDespesa.values()) {
            if (t.name().equalsIgnoreCase(tipo)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Tipo de despesa inválido: " + tipo);
    }

    public String toString() {
        return this.name().toUpperCase();
    }



}
