/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.controller;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Fornecedor;
import br.com.map.marcelo.facade.Facade;
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
public class FornecedorBean {

    private Facade facade;
    private Fornecedor fornecedor = new Fornecedor();
    private List<Fornecedor> listaFornecedores;
    private List<Fornecedor> listaFornecedoresSelecionados = new ArrayList<>();

    @PostConstruct
    public void init() {
        facade = Facade.getInstance();
        try {
            listaFornecedores = facade.listarFornecedores();
        } catch (BusinessException ex) {
            Logger.getLogger(FornecedorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getListaFornecedores() {
        return listaFornecedores;
    }

    public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
        this.listaFornecedores = listaFornecedores;
    }

    public String salvarFornecedor() {
        try {
            facade.salvarOuAtualizarFornecedor(fornecedor);
        } catch (BusinessException ex) {
            ex.printStackTrace();
        }
        return "index.jsf?faces-redirect=true";
    }

    public List<Fornecedor> getListaFornecedoresSelecionados() {
        return listaFornecedoresSelecionados;
    }

    public void setListaFornecedoresSelecionados(List<Fornecedor> listaFornecedoresSelecionados) {
        this.listaFornecedoresSelecionados = listaFornecedoresSelecionados;
    }
    
    public String removerSelecionados(){
        try {
            facade.removerFornecedores(listaFornecedoresSelecionados);
            return "todosFornecedores.jsf?faces-redirect=true";
        } catch (BusinessException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
