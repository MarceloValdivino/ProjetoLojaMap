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
    
    A_VISTA("A vista"),
    PARCELA_COM_ENTRADA("1 + Parcelas"),
    PARCELA_A_PRAZO("Entrada + parcelas");
    
    private String tipoPagamento;
    
    private TipoPagamento(String tipoPagamento){
        this.tipoPagamento = tipoPagamento;
    }
    
    public String getPagamento(){
        return tipoPagamento;
    }
}
