/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.ItemProduto;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IClienteBusiness {
    
    public void salvarOuAtualizar(Cliente cliente) throws BusinessException;

    public void remover(Cliente cliente) throws BusinessException;
    
    public void remover(List<Cliente> cliente) throws BusinessException;

    public Cliente getById(Long id) throws BusinessException;

    public List<Cliente> listar() throws BusinessException;

    public List<Cliente> listarPorNome(String nome) throws BusinessException;

    public Cliente getPorCpf(String cpf) throws BusinessException;

    public List<Cliente> listarPorTudo(String busca) throws BusinessException;
    
    public List<Cliente> listarPorComprarItemProduto(ItemProduto itemProduto) throws BusinessException;
}
