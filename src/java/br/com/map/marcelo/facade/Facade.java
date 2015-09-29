/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.facade;

import br.com.map.marcelo.business.ClienteBusinessImp;
import br.com.map.marcelo.business.FornecedorBusinessImp;
import br.com.map.marcelo.business.FuncionarioBusinessImp;
import br.com.map.marcelo.business.IClienteBusiness;
import br.com.map.marcelo.business.IFornecedorBusiness;
import br.com.map.marcelo.business.IFuncionarioBusiness;
import br.com.map.marcelo.business.IItemProdutoBusiness;
import br.com.map.marcelo.business.IItemVendaBusiness;
import br.com.map.marcelo.business.IProdutoBusiness;
import br.com.map.marcelo.business.IVendaBusiness;
import br.com.map.marcelo.business.ItemProdutoBusinessImp;
import br.com.map.marcelo.business.ItemVendaBusinessImp;
import br.com.map.marcelo.business.ProdutoBusinessImp;
import br.com.map.marcelo.business.VendaBusinessImp;
import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.dao.IItemVendaDao;
import br.com.map.marcelo.dao.ItemVendaDaoImp;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.Fornecedor;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.entidades.ItemProduto;
import br.com.map.marcelo.entidades.ItemVenda;
import br.com.map.marcelo.entidades.Produto;
import br.com.map.marcelo.entidades.Venda;
import br.com.map.marcelo.enums.TipoItemVenda;
import br.com.map.marcelo.enums.TipoPagamento;
import com.lowagie.text.ListItem;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Facade {

    private IClienteBusiness clienteBusiness;
    private IProdutoBusiness produtoBusiness;
    private IItemProdutoBusiness itemProdutoBusiness;
    private IVendaBusiness vendaBusiness;
    private IFuncionarioBusiness funcionarioBusiness;
    private IFornecedorBusiness fornecedorBusiness;
    private IItemVendaBusiness itemVendaBusiness;

    public Facade() {
        clienteBusiness = new ClienteBusinessImp();
        produtoBusiness = new ProdutoBusinessImp();
        itemProdutoBusiness = new ItemProdutoBusinessImp();
        vendaBusiness = new VendaBusinessImp();
        funcionarioBusiness = new FuncionarioBusinessImp();
        fornecedorBusiness = new FornecedorBusinessImp();
        itemVendaBusiness = new ItemVendaBusinessImp();
    }

    public void salvarOuAtualizarCliente(Cliente cliente) throws BusinessException {
        clienteBusiness.salvarOuAtualizar(cliente);
    }

    public void removerCliente(Cliente cliente) throws BusinessException {
        clienteBusiness.remover(cliente);
    }

    public Cliente buscarClientePeloId(Long id) throws BusinessException {
        return clienteBusiness.getById(id);
    }

    public List<Cliente> listarClientes() throws BusinessException {
        return clienteBusiness.listar();
    }

    public List<Cliente> listarClientesPorNome(String nome) throws BusinessException {
        return clienteBusiness.listarPorNome(nome);
    }

    public Cliente listarClientesPorCpf(String cpf) throws BusinessException {
        return clienteBusiness.getPorCpf(cpf);
    }

    public List<Cliente> listarClientePorTudo(String busca) throws BusinessException {
        return clienteBusiness.listarPorTudo(busca);
    }

    public void salvarOuAtualizarProduto(Produto produto) throws BusinessException {
        produtoBusiness.salvarOuAtualizar(produto);
    }

    public void removerProduto(Produto produto) throws BusinessException {
        produtoBusiness.remover(produto);
    }

    public Produto buscarProdutoPeloId(Long id) throws BusinessException {
        return produtoBusiness.getById(id);
    }

    public List<Produto> listarProdutos() throws BusinessException {
        return produtoBusiness.listar();
    }

    public void salvarOuAtualizarItemProduto(ItemProduto itemProduto) throws BusinessException {
        itemProdutoBusiness.salvarOuAtualizar(itemProduto);
    }

    public void removerProduto(ItemProduto produto) throws BusinessException {
        itemProdutoBusiness.remover(produto);
    }

    public ItemProduto buscarItemProdutoPeloId(Long id) throws BusinessException {
        return itemProdutoBusiness.getById(id);
    }

    public List<ItemProduto> listarItemProdutos() throws BusinessException {
        return itemProdutoBusiness.listar();
    }
    
    public void salvarOuAtualizarVenda(Venda venda) throws BusinessException {
        vendaBusiness.salvarOuAtualizar(venda);
    }

    public void removerProduto(Venda venda) throws BusinessException {
        vendaBusiness.remover(venda);
    }

    public Venda buscarVendaPeloId(Long id) throws BusinessException {
        return vendaBusiness.getById(id);
    }

    public List<Venda> listarVendas() throws BusinessException {
        return vendaBusiness.listar();
    }
    
    public List<Venda> listarVendasPorFuncionario(Funcionario funcionario) throws BusinessException{
        return vendaBusiness.listaVendasPorFuncionario(funcionario);
    }
    
    public List<Venda> listarVendasPorData(Calendar data) throws BusinessException{
        return vendaBusiness.listarPorData(data);
    }
    
    public List<Venda> listarVendasPorItemProduto(ItemProduto itemProduto) throws BusinessException{
        return vendaBusiness.listarPorItemProduto(itemProduto);
    }
    
    public List<Venda> listarVendasEntreDatas(Calendar dataInicial, Calendar dataFinal) throws BusinessException{
        return vendaBusiness.listarPorPeriodo(dataInicial, dataFinal);
    }
    
    public List<Venda> listarVendasPorTipoPagamento(TipoPagamento tipoPagamento) throws BusinessException{
        return vendaBusiness.listarPorTipoPagamento(tipoPagamento);
    }
    
    public List<ItemVenda> listarItemVendaPorTipoItemVenda(TipoItemVenda tipoItemVenda) throws BusinessException{
        return itemVendaBusiness.listarPorTipoVenda(tipoItemVenda);
    }
    
    public List<Venda> listarVendasPorDesconto(boolean desconto) throws BusinessException{
        return vendaBusiness.listarVendasComDesconto(desconto);
    }
    
    public double apuradoVendasDoMes(Calendar data) throws BusinessException{
        return vendaBusiness.aputadoMes(data);
    }
    
    public double totalDescontosMesVendas(Calendar data) throws BusinessException{
        return vendaBusiness.totalDescontosMes(data);
    }
    
    public double descontoCompraCliente(Cliente cliente) throws BusinessException{
        return vendaBusiness.valorDescontoCompraCliente(cliente);
    }
    
    public void salvarOuAtualizarFuncionario(Funcionario funcionario) throws BusinessException {
        funcionarioBusiness.salvarOuAtualizar(funcionario);
    }

    public void removerProduto(Funcionario funcionario) throws BusinessException {
        funcionarioBusiness.remover(funcionario);
    }

    public Funcionario buscarFuncionarioPeloId(Long id) throws BusinessException {
        return funcionarioBusiness.getById(id);
    }

    public List<Funcionario> listarFuncionarios() throws BusinessException {
        return funcionarioBusiness.listar();
    }
    
    public List<Funcionario> listarFuncionariosPorVenderDesconto(boolean status) throws BusinessException{
        return funcionarioBusiness.listarPorVenderDesconto(status);
    }
    
    public List<Funcionario> listarFuncionariosPorStatus(boolean status) throws BusinessException{
        return funcionarioBusiness.listarPorStatus(status);
    }
    
    public Funcionario buscarFuncionarioPeloCpf(String cpf) throws BusinessException {
        return funcionarioBusiness.getByCpf(cpf);
    }
    
    public void salvarOuAtualizarFornecedor(Fornecedor fornecedor) throws BusinessException {
        fornecedorBusiness.salvarOuAtualizar(fornecedor);
    }

    public void removerFornecedor(Fornecedor fornecedor) throws BusinessException {
        fornecedorBusiness.remover(fornecedor);
    }

    public Fornecedor buscarFornecedorPeloId(Long id) throws BusinessException {
        return fornecedorBusiness.getById(id);
    }

    public List<Fornecedor> listarFornecedores() throws BusinessException {
        return fornecedorBusiness.listar();
    }
    
    public List<ItemProduto> listarItemProdutosVendidosPorFuncionario(Funcionario funcionario) throws BusinessException{
        return itemProdutoBusiness.listarVendidosPorFuncionario(funcionario);
    }
    
    public List<ItemProduto> listarItemProdutosCompradosPorCliente(Cliente cliente) throws BusinessException{
        return itemProdutoBusiness.listarPorCompraCliente(cliente);
    }
    
    public double totalValorComprasCliente(Cliente cliente) throws BusinessException{
        return vendaBusiness.valorTotalComprar(cliente);
    }
    
    public List<Cliente> listarCompraClientePorItemProduto(ItemProduto itemProduto) throws BusinessException{
        return clienteBusiness.listarPorComprarItemProduto(itemProduto);
    }
    
    public List<Venda> listarVendasPorFuncionarioPeloStatus(boolean status) throws BusinessException{
        return vendaBusiness.listarVendasFuncionarioStatus(status);
    }
    
    public void salvarOuAtualizarItemVenda(ItemVenda itemVenda) throws BusinessException {
        itemVendaBusiness.salvarOuAtualizar(itemVenda);
    }

    public void removerCliente(ItemVenda itemVenda) throws BusinessException {
        itemVendaBusiness.remover(itemVenda);
    }

    public ItemVenda buscarItemVendaPeloId(Long id) throws BusinessException {
        return itemVendaBusiness.getById(id);
    }

    public List<ItemVenda> listarItemVendas() throws BusinessException {
        return itemVendaBusiness.listar();
    }
}
