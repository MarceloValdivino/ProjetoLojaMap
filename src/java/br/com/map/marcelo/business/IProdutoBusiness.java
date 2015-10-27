/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Produto;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IProdutoBusiness {
    
    public void salvarOuAtualizar(Produto produto) throws BusinessException;

    public void remover(Produto produto) throws BusinessException;
    
    public void remover(List<Produto> produtos) throws BusinessException;

    public Produto getById(Long id) throws BusinessException;

    public List<Produto> listar() throws BusinessException;
}
