/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.Fornecedor;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IFornecedorBusiness {
    
    public void salvarOuAtualizar(Fornecedor fornecedor) throws BusinessException;

    public void remover(Fornecedor fornecedor) throws BusinessException;

    public Fornecedor getById(Long id) throws BusinessException;

    public List<Fornecedor> listar() throws BusinessException;
}
