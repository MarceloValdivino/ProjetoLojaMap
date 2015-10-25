/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.controller;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Contato;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.enums.EstadoCivil;
import br.com.map.marcelo.enums.Operadora;
import br.com.map.marcelo.enums.Sexo;
import br.com.map.marcelo.facade.Facade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

    private Facade facade;
    private String login;
    private String senha;
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> listaFuncionarios;
    private Contato contato = new Contato();

    @PostConstruct
    public void init() {
        facade = Facade.getInstance();
        try {
            listaFuncionarios = facade.listarFuncionarios();
        } catch (BusinessException ex) {
            Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Contato getContato() {
        return contato;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String logar() {
        if (autenticar()) {
            return "index.jsf?faces-redirect=true";
        } else {
            return "";
        }
    }

    public boolean autenticar() {
        try {
            if (login.equals("admin") && senha.equals("admin")) {
                FacesContext fc = FacesContext.getCurrentInstance();
                ExternalContext ec = fc.getExternalContext();
                HttpSession session = (HttpSession) ec.getSession(false);
                session.setAttribute("funcionario", funcionario);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public EstadoCivil[] getEstadosCivis() {
        return EstadoCivil.values();
    }

    public Sexo[] getSexos() {
        return Sexo.values();
    }

    public Operadora[] getOperadoras() {
        return Operadora.values();
    }

    public void adicionarContato() {
        funcionario.getContatos().add(contato);
        contato = new Contato();
    }

    public String salvarFuncionario() {
        try {
            facade.salvarOuAtualizarFuncionario(funcionario);
        } catch (BusinessException ex) {
            ex.printStackTrace();
        }
        return "index.jsf?faces-redirect=true";
    }
}
