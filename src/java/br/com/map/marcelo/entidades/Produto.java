/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.entidades;

import br.com.map.marcelo.enums.ComposicaoProduto;
import br.com.map.marcelo.enums.TipoProduto;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Marcelo
 */
@Entity
public class Produto implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private TipoProduto tipoProduto;
    private ComposicaoProduto composicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public ComposicaoProduto getComposicao() {
        return composicao;
    }

    public void setComposicao(ComposicaoProduto composicao) {
        this.composicao = composicao;
    }
    
    
    
}
