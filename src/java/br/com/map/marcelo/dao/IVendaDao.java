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
import br.com.map.marcelo.entidades.Venda;
import br.com.map.marcelo.enums.TipoItemVenda;
import br.com.map.marcelo.enums.TipoPagamento;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IVendaDao extends IGenericDao<Venda>{
    
    public List<Venda> listarPorPeriodo(Calendar dataInicial, Calendar dataFinal)throws DAOException;
    
    public List<Venda> listarPorCompraCliente(Cliente cliente) throws DAOException;
    
    public List<Venda> listarPorTipoPagamento(TipoPagamento tipoPagamento) throws DAOException;
    
    public List<Venda> listarPorItemProduto(ItemProduto itemProduto) throws DAOException;
    
    public List<Venda> listarVendasComDesconto(boolean desconto) throws DAOException;
    
    public List<Venda> listaVendasPorFuncionario(Funcionario funcionario) throws DAOException;
    
    public double aputadoMes(Calendar dataInicial, Calendar dataFinal) throws DAOException;
    
}
