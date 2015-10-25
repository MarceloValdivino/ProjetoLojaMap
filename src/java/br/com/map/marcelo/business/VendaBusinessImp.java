/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.commom.strategy.ParcelaAPrazo;
import br.com.map.marcelo.commom.strategy.ParcelaAVista;
import br.com.map.marcelo.commom.strategy.ParcelasMaisEntrada;
import br.com.map.marcelo.dao.IVendaDao;
import br.com.map.marcelo.dao.VendaDaoImp;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.ConfiguracaoPagamento;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.entidades.ItemProduto;
import br.com.map.marcelo.entidades.ItemVenda;
import br.com.map.marcelo.entidades.Venda;
import br.com.map.marcelo.enums.TipoPagamento;
import br.com.map.marcelo.utils.DateUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class VendaBusinessImp implements IVendaBusiness {

    private IVendaDao vendaDao;

    public VendaBusinessImp() {
        vendaDao = new VendaDaoImp();
    }

    @Override
    public void salvarOuAtualizar(Venda venda) throws BusinessException {
        for (ItemVenda itemVenda : venda.getItens()) {
            switch (itemVenda.getTipoItemVenda()) {
                case ATACADO: {
                    itemVenda.setPrecoItem((itemVenda.getItemProduto().getPorcentagemVendaUnidadeAtacado() + 1) * (itemVenda.getItemProduto().getPrecoCompraUnidade()) * (1 - itemVenda.getDescontoPorcentagemItem()));
                }
                break;
                case VAREJO: {
                    itemVenda.setPrecoItem((itemVenda.getItemProduto().getPorcentagemVendaUnidadeVarejo() + 1) * (itemVenda.getItemProduto().getPrecoCompraUnidade()) * (1 - itemVenda.getDescontoPorcentagemItem()));
                }
                break;
            }
        }
        try {
            if (venda.getId() != null) {
                vendaDao.update(venda);
            } else {
                vendaDao.save(venda);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(Venda venda) throws BusinessException {
        try {
            vendaDao.remove(venda);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Venda getById(Long id) throws BusinessException {
        try {
            return vendaDao.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Venda> listar() throws BusinessException {
        try {
            return vendaDao.list();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Venda> listarPorPeriodo(Calendar dataInicial, Calendar dataFinal) throws BusinessException {
        dataInicial.set(Calendar.HOUR_OF_DAY, 0);
        dataInicial.set(Calendar.SECOND, 0);
        dataInicial.set(Calendar.MINUTE, 0);
        dataInicial.set(Calendar.MILLISECOND, 0);
        String data1 = DateUtil.getDate(dataInicial.getTime());

        dataFinal.set(Calendar.HOUR_OF_DAY, 0);
        dataFinal.set(Calendar.SECOND, 0);
        dataFinal.set(Calendar.MINUTE, 0);
        dataFinal.set(Calendar.MILLISECOND, 0);
        String data2 = DateUtil.getDate(dataFinal.getTime());
        System.out.println("Data inicial: " + data1);
        System.out.println("Data final: " + data2);
        try {
            return vendaDao.listarPorPeriodo(dataInicial, dataFinal);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public double valorDescontoCompraCliente(Cliente cliente) throws BusinessException {
        try {
            List<Venda> lista = vendaDao.listarPorCompraCliente(cliente);
            double desconto = 0;
            for (Venda v : lista) {
                for (ItemVenda i : v.getItens()) {
                    desconto = desconto + ((i.getDescontoPorcentagemItem() * i.getPrecoItem()) / 100);
                }
            }
            return desconto;
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Venda> listarPorData(Calendar dataVendas) throws BusinessException {
        dataVendas.set(Calendar.HOUR_OF_DAY, 0);
        dataVendas.set(Calendar.SECOND, 0);
        dataVendas.set(Calendar.MINUTE, 0);
        dataVendas.set(Calendar.MILLISECOND, 0);

        Calendar dataFinal = Calendar.getInstance();
        dataFinal.set(dataVendas.get(Calendar.YEAR), dataVendas.get(Calendar.MONTH), dataVendas.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        dataFinal.add(Calendar.MONTH, 1);
        dataFinal.add(Calendar.SECOND, -1);

        String dataInicial = DateUtil.getDate(dataVendas.getTime());
        String dataFinalString = DateUtil.getDate(dataFinal.getTime());
        System.out.println("Data inicial: " + dataInicial);
        System.out.println("Data final: " + dataFinalString);

        try {
            return vendaDao.listarPorPeriodo(dataVendas, dataFinal);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Venda> listarPorTipoPagamento(TipoPagamento tipoPagamento) throws BusinessException {
        try {
            return vendaDao.listarPorTipoPagamento(tipoPagamento);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Venda> listarPorItemProduto(ItemProduto itemProduto) throws BusinessException {
        try {
            return vendaDao.listarPorItemProduto(itemProduto);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Venda> listarVendasComDesconto(boolean desconto) throws BusinessException {
        try {
            return vendaDao.listarVendasComDesconto(desconto);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Venda> listaVendasPorFuncionario(Funcionario funcionario) throws BusinessException {
        try {
            return vendaDao.listaVendasPorFuncionario(funcionario);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public double aputadoMes(Calendar calendar) throws BusinessException {
        try {
            System.out.println("Calendar: " + DateUtil.getDate(calendar.getTime()));
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 1);

            Calendar dataInicial = calendar;
            Calendar dataFinal = Calendar.getInstance();
            dataFinal.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

            dataFinal.add(Calendar.MONTH, 1);
            dataFinal.add(Calendar.SECOND, -1);
            System.out.println("Data Inicial: " + DateUtil.getDate(dataInicial.getTime()));
            System.out.println("Data Final: " + DateUtil.getDate(dataFinal.getTime()));

            return vendaDao.aputadoMes(dataInicial, dataFinal);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public double totalDescontosMes(Calendar data) throws BusinessException {
        try {
            Calendar dataInicial = Calendar.getInstance();
            dataInicial.set(data.get(Calendar.YEAR), data.get(Calendar.MONTH), data.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
            dataInicial.set(Calendar.DAY_OF_MONTH, 1);

            Calendar dataFinal = data;
            dataFinal.add(Calendar.MONTH, 1);
            dataFinal.set(Calendar.DAY_OF_MONTH, 1);
            dataFinal.add(Calendar.DAY_OF_MONTH, -1);

            String dataInicialString = DateUtil.getDate(dataInicial.getTime());
            String dataFinalString = DateUtil.getDate(dataFinal.getTime());
            System.out.println("Data inicial: " + dataInicialString);
            System.out.println("Data final: " + dataFinalString);

            double desconto = 0;

            for (Venda v : vendaDao.listarPorPeriodo(dataInicial, dataFinal)) {
                for (ItemVenda i : v.getItens()) {
                    desconto = desconto + i.getDescontoPorcentagemItem();
                }
            }
            return desconto;
        } catch (DAOException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public double valorTotalComprar(Cliente cliente) throws BusinessException {
        List<Venda> lista = new ArrayList<>();
        double valor = 0;
        for (Venda v : listar()) {
            if (v.getCliente().equals(cliente)) {
                valor += v.getPrecoTotal();
            }
        }
        return valor;
    }

    @Override
    public List<Venda> listarVendasFuncionarioStatus(boolean status) throws BusinessException {
        List<Venda> lista = new ArrayList<>();
        for (Venda v : listar()) {
            if (v.getFuncionario().getStatus() == status) {
                lista.add(v);
            }
        }
        return lista;
    }

    @Override
    public void efetuarVenda(Funcionario funcionario, Cliente cliente, int quantidadeParcelas, ConfiguracaoPagamento configuracaoPagamento) throws BusinessException {
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setFuncionario(funcionario);
        venda.setTipoPagamento(configuracaoPagamento.getTipoPagamento());
        venda.setQuantidadeParcelas(quantidadeParcelas);
        venda.setDataVenda(Calendar.getInstance());
        venda.setConfiguracaoPagamento(configuracaoPagamento);
        switch (configuracaoPagamento.getTipoPagamento()) {
            case A_VISTA: {
                venda.setGeradorParcelasStrategy(new ParcelaAVista());
                venda.gerarParcelas();
            }
            break;
            case PARCELA_A_PRAZO: {
                venda.setGeradorParcelasStrategy(new ParcelaAPrazo());
                venda.gerarParcelas();
            }
            break;
            case PARCELA_COM_ENTRADA: {
                venda.setGeradorParcelasStrategy(new ParcelasMaisEntrada());
                venda.gerarParcelas();
            }
            break;
        }
        venda.gerarParcelas();
        salvarOuAtualizar(venda);
    }
}
