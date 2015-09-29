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
    
    ALIMENTICIO(1),
    CASA(2);
    
    private int tipo;
    
    private TipoProduto(int tipoProduto){
        this.tipo = tipoProduto;
    }
    
    public int getTipo(){
        return this.tipo;
    }
}
