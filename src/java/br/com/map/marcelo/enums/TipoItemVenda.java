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
    
    VAREJO("Varejo",0),
    ATACADO("Atacado",10.0);
    
    private String tipoItemVenda;
    private double valorDescontoVenda;
    
    private TipoItemVenda(String tipoItemVenda, double valorDesconto){
        this.tipoItemVenda = tipoItemVenda;
        this.valorDescontoVenda = valorDesconto;
    }
    
    public String getTipoItemVenda(){
        return tipoItemVenda;
    }
    
    public double getValorDescontoVenda(){
        return valorDescontoVenda;
    }
}
