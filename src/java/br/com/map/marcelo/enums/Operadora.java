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
public enum Operadora {

    OI("Oi"),
    VIVO("Vivo"),
    TIM("Tim"),
    CLARO("Claro");
    
    private String operadora;
    
    private Operadora(String operadora){
        this.operadora = operadora;
    }
    
    public String getOperadora(){
        return this.operadora;
    }
}
