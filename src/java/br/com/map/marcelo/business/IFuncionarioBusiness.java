/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Funcionario;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IFuncionarioBusiness {
    
    public void salvarOuAtualizar(Funcionario funcionario) throws BusinessException;

    public void remover(Funcionario funcionario) throws BusinessException;

    public Funcionario getById(Long id) throws BusinessException;

    public List<Funcionario> listar() throws BusinessException;
    
    public List<Funcionario> listarPorVenderDesconto(boolean desconto) throws BusinessException;
    
    public List<Funcionario> listarPorStatus(boolean status) throws BusinessException;
    
    public Funcionario getByCpf(String cpf) throws BusinessException;
}
