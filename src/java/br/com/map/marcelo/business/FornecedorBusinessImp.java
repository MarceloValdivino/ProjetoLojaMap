/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.dao.FornecedorDaoImp;
import br.com.map.marcelo.dao.IFornecedorDao;
import br.com.map.marcelo.entidades.Fornecedor;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class FornecedorBusinessImp implements IFornecedorBusiness {

    private IFornecedorDao fornecedorDao;
    
    public FornecedorBusinessImp(){
        fornecedorDao = new FornecedorDaoImp();
    }
    
    @Override
    public void salvarOuAtualizar(Fornecedor fornecedor) throws BusinessException {
        try {
            if (fornecedor.getId() != null) {
                fornecedorDao.update(fornecedor);
            } else {
                fornecedorDao.save(fornecedor);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(Fornecedor fornecedor) throws BusinessException {
        try {
            fornecedorDao.remove(fornecedor);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Fornecedor getById(Long id) throws BusinessException {
        try {
            return fornecedorDao.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Fornecedor> listar() throws BusinessException {
        try {
            return this.fornecedorDao.list();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
    
}
