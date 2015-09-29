/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.dao.IProdutoDao;
import br.com.map.marcelo.dao.ProdutoDaoImp;
import br.com.map.marcelo.entidades.Produto;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class ProdutoBusinessImp implements IProdutoBusiness {

    private IProdutoDao produtoDao;

    public ProdutoBusinessImp() {
        this.produtoDao = new ProdutoDaoImp();
    }

    @Override
    public void salvarOuAtualizar(Produto produto) throws BusinessException {
        try {
            if (produto.getId() != null) {
                produtoDao.update(produto);
            } else {
                produtoDao.save(produto);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(Produto produto) throws BusinessException {
        try {
            produtoDao.remove(produto);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Produto getById(Long id) throws BusinessException {
        try {
            return produtoDao.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Produto> listar() throws BusinessException {
        try {
            return produtoDao.list();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
}
