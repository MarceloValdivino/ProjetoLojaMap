/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;

/**
 *
 * @author Marcelo
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Pessoa implements Serializable {

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataCadastro;

    public Cliente() {
        dataCadastro = Calendar.getInstance();
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
