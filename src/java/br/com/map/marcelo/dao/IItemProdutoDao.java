/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.dao;

import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.entidades.ItemProduto;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IItemProdutoDao extends IGenericDao<ItemProduto> {
    
    public List<ItemProduto> listarPorCompraCliente(Cliente cliente) throws DAOException;
    
    public List<ItemProduto> listarVendidosPorFuncionario(Funcionario funcionario) throws DAOException;
    
}
