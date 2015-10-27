/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.controller;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.ItemVenda;
import br.com.map.marcelo.entidades.Venda;
import br.com.map.marcelo.enums.TipoItemVenda;
import br.com.map.marcelo.enums.TipoPagamento;
import br.com.map.marcelo.facade.Facade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {

    private Venda venda = new Venda();
    private ItemVenda itemVenda = new ItemVenda();
    private List<Venda> listaDeVendas;
    private List<Venda> listaDeVendasSelecionadas = new ArrayList<>();
    private Facade facade;

    @PostConstruct
    public void init() {
        facade = Facade.getInstance();
        try {
            listaDeVendas = facade.listarVendas();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Venda> getListaDeVendas() {
        return listaDeVendas;
    }

    public void setListaDeVendas(List<Venda> listaDeVendas) {
        this.listaDeVendas = listaDeVendas;
    }

    public String salvarVenda() {
        try {
            facade.salvarOuAtualizarVenda(venda);
            return "index.jsp?faces-redirect=true";
        } catch (BusinessException ex) {
            Logger.getLogger(VendaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public TipoPagamento[] getTiposDePagamento() {
        return TipoPagamento.values();
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public TipoItemVenda[] getTiposItemVenda() {
        return TipoItemVenda.values();
    }

    public void adiconarItem() {
        venda.getItens().add(itemVenda);
        itemVenda = new ItemVenda();
        System.out.println("Adicionei essa kcta!");
    }

    public String adicionarVenda() {
        try {
            facade.salvarOuAtualizarVenda(venda);
            return "index.jsf?faces-redirect=true";
        } catch (BusinessException ex) {
            Logger.getLogger(VendaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public List<Venda> getListaDeVendasSelecionadas() {
        return listaDeVendasSelecionadas;
    }

    public void setListaDeVendasSelecionadas(List<Venda> listaDeVendasSelecionadas) {
        this.listaDeVendasSelecionadas = listaDeVendasSelecionadas;
    }

    public String removerSelecionadas() {
        try {
            facade.removerVendas(listaDeVendasSelecionadas);
            return "todasVendas.jsf?faces-redirect=true";
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return "";
    }
}
