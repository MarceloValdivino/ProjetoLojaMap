/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.dao.IItemVendaDao;
import br.com.map.marcelo.dao.ItemVendaDaoImp;
import br.com.map.marcelo.entidades.ItemVenda;
import br.com.map.marcelo.enums.TipoItemVenda;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class ItemVendaBusinessImp implements IItemVendaBusiness {

    private IItemVendaDao itemVendaDao;

    public ItemVendaBusinessImp(){
        this.itemVendaDao = new ItemVendaDaoImp();
    }
    
    @Override
    public void salvarOuAtualizar(ItemVenda itemVenda) throws BusinessException {
        try {
            if (itemVenda.getId() != null) {
                itemVendaDao.update(itemVenda);
            } else {
                itemVendaDao.save(itemVenda);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(ItemVenda itemVenda) throws BusinessException {
        try {
            itemVendaDao.remove(itemVenda);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public ItemVenda getById(Long id) throws BusinessException {
        try {
            return itemVendaDao.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<ItemVenda> listar() throws BusinessException {
        try {
            return itemVendaDao.list();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<ItemVenda> listarPorTipoVenda(TipoItemVenda tipoItemVenda) throws BusinessException {
        try{
            return itemVendaDao.listarPorTipoVenda(tipoItemVenda);
        }catch(DAOException e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

}
