/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.entidades.ItemProduto;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IItemProdutoBusiness {
    
    public void salvarOuAtualizar(ItemProduto itemProduto) throws BusinessException;

    public void remover(ItemProduto itemProduto) throws BusinessException;

    public ItemProduto getById(Long id) throws BusinessException;

    public List<ItemProduto> listar() throws BusinessException;
    
    public List<ItemProduto> listarVendidosPorFuncionario(Funcionario funcionario) throws BusinessException;
    
    public List<ItemProduto> listarPorCompraCliente(Cliente cliente) throws BusinessException;
}
