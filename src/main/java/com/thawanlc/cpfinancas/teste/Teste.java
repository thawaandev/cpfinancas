package com.thawanlc.cpfinancas.teste;



import com.thawanlc.cpfinancas.entity.Financa;
import com.thawanlc.cpfinancas.entity.Usuario;
import com.thawanlc.cpfinancas.entity.enums.TipoDespesa;

public class Teste {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.setNome("Thawan");

        Financa financa = new Financa();
        financa.setDescricao("Parcela Apartamento");
        financa.setValor(500.00);
        financa.setTipoDespesa(TipoDespesa.MORADIA);
        financa.setUsuario(usuario);

        Financa f2 = new Financa();
        f2.setDescricao("Parcela IPHONE 14");
        f2.setValor(120.00);
        f2.setTipoDespesa(TipoDespesa.OUTROS);
        f2.setUsuario(usuario);

        Financa f3 = new Financa();
        f3.setDescricao("Parcela Sahara300");
        f3.setValor(950.00);
        f3.setTipoDespesa(TipoDespesa.OUTROS);
        f3.setUsuario(usuario);

        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Finança 1: " + financa.getDescricao() + " - Valor: " + financa.getValor() + " - Tipo: " + financa.getTipoDespesa());
        System.out.println("Finança 2: " + f2.getDescricao() + " - Valor: " + f2.getValor() + " - Tipo: " + f2.getTipoDespesa());
        System.out.println("Finança 3: " + f3.getDescricao() + " - Valor: " + f3.getValor() + " - Tipo: " + f3.getTipoDespesa());

    }
    
}
