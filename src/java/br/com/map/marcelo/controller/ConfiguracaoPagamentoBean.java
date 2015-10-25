/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.controller;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.ConfiguracaoPagamento;
import br.com.map.marcelo.enums.TipoPagamento;
import br.com.map.marcelo.facade.Facade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@ViewScoped
public class ConfiguracaoPagamentoBean implements Serializable {
    
    public ConfiguracaoPagamento configuracaoPagamento = new ConfiguracaoPagamento();
    public List<ConfiguracaoPagamento> listaDeConfiguracaoPagamento;
    public Facade facade;

    public ConfiguracaoPagamentoBean() {
        facade = Facade.getInstance();
        try {
            listaDeConfiguracaoPagamento = facade.listarConfiguracaoPagamento();
        } catch (BusinessException ex) {
            Logger.getLogger(ConfiguracaoPagamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ConfiguracaoPagamento getConfiguracaoPagamento() {
        return configuracaoPagamento;
    }

    public void setConfiguracaoPagamento(ConfiguracaoPagamento configuracaoPagamento) {
        this.configuracaoPagamento = configuracaoPagamento;
    }

    public List<ConfiguracaoPagamento> getListaDeConfiguracaoPagamento() {
        return listaDeConfiguracaoPagamento;
    }

    public void setListaDeConfiguracaoPagamento(List<ConfiguracaoPagamento> listaDeConfiguracaoPagamento) {
        this.listaDeConfiguracaoPagamento = listaDeConfiguracaoPagamento;
    }

    public TipoPagamento[] getTiposDePagamento(){
        return TipoPagamento.values();
    }
    
    public String salvarConfiguracaoPagamento(){
        try {
            facade.salvarOuAtualizarCliente(configuracaoPagamento);
            return "index.jsf?faces-redirect=true";
        } catch (BusinessException ex) {
            Logger.getLogger(ConfiguracaoPagamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}

