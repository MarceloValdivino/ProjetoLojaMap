package br.com.map.marcelo.dao;


import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.ItemProduto;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcelo
 */
public interface IClienteDao extends IGenericDao<Cliente>{

    public List<Cliente> listPorNome(String nome) throws DAOException;
    public List<Cliente> listPorBusca(String busca) throws DAOException;
    public Cliente getPorCpf(String cpf) throws DAOException;
    
    public List<Cliente> listarPorCompra(ItemProduto itemProduto) throws DAOException;
}
