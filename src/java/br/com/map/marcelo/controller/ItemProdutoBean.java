/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.controller;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.ItemProduto;
import br.com.map.marcelo.facade.Facade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@ViewScoped
public class ItemProdutoBean implements Serializable {

    private Facade facade;
    private ItemProduto ItemProduto = new ItemProduto();
    private List<ItemProduto> itemProdutosSelecionados = new ArrayList<>();
    private List<ItemProduto> listaItensProduto;
    
    @PostConstruct
    public void init(){
        facade = Facade.getInstance();
        try {
            listaItensProduto = facade.listarItemProdutos();
        } catch (BusinessException ex) {
            ex.printStackTrace();
        }
    }

    public ItemProduto getItemProduto() {
        return ItemProduto;
    }

    public void setItemProduto(ItemProduto ItemProduto) {
        this.ItemProduto = ItemProduto;
    }

    public List<ItemProduto> getListaItensProduto() {
        return listaItensProduto;
    }

    public void setListaItensProduto(List<ItemProduto> listaItensProduto) {
        this.listaItensProduto = listaItensProduto;
    }
    
    public String salvarItemProduto(){
        try {
            facade.salvarOuAtualizarItemProduto(ItemProduto);
        } catch (BusinessException ex) {
            ex.printStackTrace();
        }
        return "index.jsf?faces-redirect=true";
    }

    public List<ItemProduto> getItemProdutosSelecionados() {
        return itemProdutosSelecionados;
    }

    public void setItemProdutosSelecionados(List<ItemProduto> itemProdutosSelecionados) {
        this.itemProdutosSelecionados = itemProdutosSelecionados;
    }
    
    public String removerSelecionados(){
        try {
            facade.removerItemProdutos(itemProdutosSelecionados);
            return "todosItemProduto.jsf?faces-redirect=true";
        } catch (BusinessException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
