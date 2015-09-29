/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.dao;

import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.entidades.Funcionario;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IFuncionarioDao extends IGenericDao<Funcionario>{
    
    public List<Funcionario> listarPorVenderDesconto(boolean desconto) throws DAOException;
    
    public List<Funcionario> listarPorStatus(boolean status) throws DAOException;
    
    public Funcionario getByCpf(String cpf) throws DAOException;
}
