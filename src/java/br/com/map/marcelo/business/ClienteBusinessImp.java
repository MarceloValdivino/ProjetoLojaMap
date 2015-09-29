/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.commom.exception.ValidationException;
import br.com.map.marcelo.dao.ClienteDaoImp;
import br.com.map.marcelo.dao.IClienteDao;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.ItemProduto;
import br.com.map.marcelo.validation.Validation;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class ClienteBusinessImp implements IClienteBusiness {

    private IClienteDao clienteDao;

    public ClienteBusinessImp() {
        this.clienteDao = new ClienteDaoImp();
    }

    @Override
    public void salvarOuAtualizar(Cliente cliente) throws BusinessException {
        try {
            Validation.validarCliente(cliente);
            if (cliente.getId() != null) {
                clienteDao.update(cliente);
            } else {
                clienteDao.save(cliente);
            }
        } catch (DAOException|ValidationException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(Cliente cliente) throws BusinessException {
        try {
            clienteDao.remove(cliente);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Cliente getById(Long id) throws BusinessException {
        Cliente c = null;
        try {
            c = clienteDao.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        return c;
    }

    @Override
    public List<Cliente> listar() throws BusinessException {
        try {
            return clienteDao.list();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }

    }

    @Override
    public List<Cliente> listarPorNome(String nome) throws BusinessException {
        try {
            return clienteDao.listPorNome(nome);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Cliente getPorCpf(String cpf) throws BusinessException {
        try {
            return clienteDao.getPorCpf(cpf);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> listarPorTudo(String busca) throws BusinessException {
        try {
            return clienteDao.listPorBusca(busca);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> listarPorComprarItemProduto(ItemProduto itemProduto) throws BusinessException {
        try {
            return clienteDao.listarPorCompra(itemProduto);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
}
