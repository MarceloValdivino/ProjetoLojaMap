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
public enum TipoProduto {
    
    ALIMENTICIO("Alimenticio"),
    CASA("Casa");
    
    private String tipo;
    
    private TipoProduto(String tipoProduto){
        this.tipo = tipoProduto;
    }
    
    public String getTipo(){
        return this.tipo;
    }
}
