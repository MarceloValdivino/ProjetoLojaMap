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
public enum ComposicaoProduto {
    
    AGUA("Agua"),
    MADEIRA("Madeira"),
            METAL("Metal");
    
    private String composicao;
    
    private ComposicaoProduto(String composicao){
        this.composicao = composicao;
    }

    public String getComposicao(){
        return this.composicao;
    }
}
