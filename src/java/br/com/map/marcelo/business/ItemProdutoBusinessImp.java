/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.dao.IItemProdutoDao;
import br.com.map.marcelo.dao.ItemProdutoImp;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.entidades.ItemProduto;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcelo
 */
public class ItemProdutoBusinessImp implements IItemProdutoBusiness {

    private IItemProdutoDao itemProdutoDao;

    public ItemProdutoBusinessImp() {
        this.itemProdutoDao = new ItemProdutoImp();
    }

    @Override
    public void salvarOuAtualizar(ItemProduto produto) throws BusinessException {
        produto.setDataEntrada(Calendar.getInstance());
        try {
            if (produto.getId() != null) {
                itemProdutoDao.update(produto);
            } else {
                itemProdutoDao.save(produto);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(ItemProduto produto) throws BusinessException {
        try {
            itemProdutoDao.remove(produto);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(List<ItemProduto> produtos) throws BusinessException {
        try {
            for (ItemProduto produto : produtos) {
                itemProdutoDao.remove(produto);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public ItemProduto getById(Long id) throws BusinessException {
        try {
            return itemProdutoDao.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<ItemProduto> listar() throws BusinessException {
        try {
            return this.itemProdutoDao.list();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<ItemProduto> listarVendidosPorFuncionario(Funcionario funcionario) throws BusinessException {
        try {
            return itemProdutoDao.listarVendidosPorFuncionario(funcionario);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<ItemProduto> listarPorCompraCliente(Cliente cliente) throws BusinessException {
        try {
            return itemProdutoDao.listarPorCompraCliente(cliente);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
}
