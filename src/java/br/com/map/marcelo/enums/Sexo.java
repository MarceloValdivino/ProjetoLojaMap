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
public enum Sexo {

    MASCULINO("M"),
    FEMININO("F");
    
    private String sexo;
    
    private Sexo(String sexo){
        this.sexo = sexo;
    }
    
    public String getSexo(){
        return this.sexo;
    }
}
