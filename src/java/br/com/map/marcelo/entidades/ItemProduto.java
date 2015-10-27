/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marcelo
 */
@Entity
public class ItemProduto implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Produto produto;
    private int quantidade;
    private double precoCompraUnidade;
    private double porcentagemVendaUnidadeVarejo;
    private double porcentagemVendaUnidadeAtacado;
    @ManyToOne
    private Fornecedor fornecedor;
    @Temporal(TemporalType.DATE)
    private Calendar dataEntrada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoCompraUnidade() {
        return precoCompraUnidade;
    }

    public void setPrecoCompraUnidade(double precoCompraUnidade) {
        this.precoCompraUnidade = precoCompraUnidade;
    }

    public double getPorcentagemVendaUnidadeVarejo() {
        return porcentagemVendaUnidadeVarejo;
    }

    public void setPorcentagemVendaUnidadeVarejo(double porcentagemVendaUnidadeVarejo) {
        this.porcentagemVendaUnidadeVarejo = porcentagemVendaUnidadeVarejo;
    }

    public double getPorcentagemVendaUnidadeAtacado() {
        return porcentagemVendaUnidadeAtacado;
    }

    public void setPorcentagemVendaUnidadeAtacado(double porcentagemVendaUnidadeAtacado) {
        this.porcentagemVendaUnidadeAtacado = porcentagemVendaUnidadeAtacado;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemProduto other = (ItemProduto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
