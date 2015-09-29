/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.entidades;

import br.com.map.marcelo.enums.TipoItemVenda;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Marcelo
 */
@Entity
public class ItemVenda implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ItemProduto itemProduto;
    private int quantidade;
    private double precoItem;
    private double descontoPorcentagemItem;
    private TipoItemVenda tipoItemVenda;
    private boolean desconto;
    
    public ItemVenda(){
        this.tipoItemVenda = TipoItemVenda.VAREJO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemProduto getItemProduto() {
        return itemProduto;
    }

    public void setItemProduto(ItemProduto itemProduto) {
        this.itemProduto = itemProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    public double getDescontoPorcentagemItem() {
        return descontoPorcentagemItem;
    }

    public void setDescontoPorcentagemItem(double descontoPorcentagemItem) {
        this.descontoPorcentagemItem = descontoPorcentagemItem;
    }

    public TipoItemVenda getTipoItemVenda() {
        return tipoItemVenda;
    }

    public void setTipoItemVenda(TipoItemVenda tipoItemVenda) {
        this.tipoItemVenda = tipoItemVenda;
    }

    public boolean isDesconto() {
        return desconto;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }    
}
