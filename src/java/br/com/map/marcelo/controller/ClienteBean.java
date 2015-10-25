/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.controller;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.Contato;
import br.com.map.marcelo.enums.EstadoCivil;
import br.com.map.marcelo.enums.Operadora;
import br.com.map.marcelo.enums.Sexo;
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
public class ClienteBean implements Serializable {
    
    public Cliente cliente = new Cliente();
    public Contato contato = new Contato();
    public List<Cliente> listaDeClientes;
    public Facade facade;
    
    @PostConstruct
    public void init(){
        facade = Facade.getInstance();
        try{
            listaDeClientes = facade.listarClientes();
        }catch(BusinessException be){
            be.printStackTrace();
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }
    
    public EstadoCivil[] getEstadosCivis() {
        return EstadoCivil.values();
    }
    
    public Sexo[] getSexos(){
        return Sexo.values();
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    public Operadora[] getOperadoras(){
        return Operadora.values();
    }
    
    public void adicionarContato(){
        cliente.getContatos().add(contato);
        contato = new Contato();
    }
    
    public String salvarCliente(){
        try {
            facade.salvarOuAtualizarCliente(cliente);
            return "index.jsp?faces-redirect=true";
        } catch (BusinessException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
