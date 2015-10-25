/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.ConfiguracaoPagamento;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.entidades.ItemProduto;
import br.com.map.marcelo.entidades.ItemVenda;
import br.com.map.marcelo.entidades.Venda;
import br.com.map.marcelo.enums.TipoItemVenda;
import br.com.map.marcelo.enums.TipoPagamento;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IVendaBusiness {
    public void salvarOuAtualizar(Venda venda) throws BusinessException;

    public void remover(Venda venda) throws BusinessException;

    public Venda getById(Long id) throws BusinessException;

    public List<Venda> listar() throws BusinessException;
    
    public List<Venda> listarPorPeriodo(Calendar dataInicial, Calendar dataFinal)throws BusinessException;
    
    public double valorDescontoCompraCliente(Cliente cliente) throws BusinessException;
    
    public List<Venda> listarPorData(Calendar dataVendas) throws BusinessException;
    
    public List<Venda> listarPorTipoPagamento(TipoPagamento tipoPagamento) throws BusinessException;
    
    public List<Venda> listarPorItemProduto(ItemProduto itemProduto) throws BusinessException;
    
    public List<Venda> listarVendasComDesconto(boolean desconto) throws BusinessException;
    
    public List<Venda> listaVendasPorFuncionario(Funcionario funcionario) throws BusinessException;
    
    public double aputadoMes(Calendar calendar) throws BusinessException;
    
    public double totalDescontosMes(Calendar data) throws BusinessException;
    
    public double valorTotalComprar(Cliente cliente) throws BusinessException;
    
    public List<Venda> listarVendasFuncionarioStatus(boolean status) throws BusinessException;
    
    public void efetuarVenda(Funcionario funcionario, Cliente cliente, int quantidadeParcelas, ConfiguracaoPagamento configuracaoPagamento) throws BusinessException;
}
