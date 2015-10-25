/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.controller;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Produto;
import br.com.map.marcelo.enums.ComposicaoProduto;
import br.com.map.marcelo.enums.TipoProduto;
import br.com.map.marcelo.facade.Facade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
    
    private Produto produto = new Produto();
    private List<Produto> listaProdutos;
    private Facade facade;
    
    @PostConstruct
    private void init(){
        facade = Facade.getInstance();
        try {
            listaProdutos = facade.listarProdutos();
            System.out.println(listaProdutos);
        } catch (BusinessException ex) {
            ex.printStackTrace();
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public TipoProduto[] getTiposProduto() {
        return TipoProduto.values();
    }
    
    public ComposicaoProduto[] getComposicoesProduto(){
        return ComposicaoProduto.values();
    }
    
    public String salvarProduto(){
        try {
            facade.salvarOuAtualizarProduto(produto);
        } catch (BusinessException ex) {
            ex.printStackTrace();
        }
        return "index.jsf";
    }
}
