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
public enum TipoItemVenda {
    
    VAREJO("Varejo"),
    ATACADO("Atacado");
    
    private String tipoItemVenda;
    
    private TipoItemVenda(String tipoItemVenda){
        this.tipoItemVenda = tipoItemVenda;
    }
    
    public String getTipoItemVenda(){
        return tipoItemVenda;
    }
}
