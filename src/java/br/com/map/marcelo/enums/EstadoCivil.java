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
public enum EstadoCivil {
    
    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    VIUVI("Viuvo"),
    SEPARADO("Separado"),
    UNIAO_ESTAVEL("União Estável");

    private String estadoCivil;
    
    private EstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }

    public String getEstadoCivil(){
        return this.estadoCivil;
    }
}
