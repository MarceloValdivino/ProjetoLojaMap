/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.enums;

/**
 *
 * @author Marcelo
 */
public enum TipoPagamento {
    
    DINHEIRO("Dinheiro"),
    CARTAO("Cartão"),
    NOTA_PROMISSORIA("Nota Promissória");
    
    private String tipoPagamento;
    
    private TipoPagamento(String tipoPagamento){
        this.tipoPagamento = tipoPagamento;
    }
    
    public String getPagamento(){
        return tipoPagamento;
    }
}
