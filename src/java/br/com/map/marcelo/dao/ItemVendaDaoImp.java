/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.dao;

import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.entidades.ItemVenda;
import br.com.map.marcelo.enums.TipoItemVenda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
public class ItemVendaDaoImp extends GenericDaoImp<ItemVenda> implements IItemVendaDao {
    
    private EntityManager manager;
    
    @Override
    public List<ItemVenda> listarPorTipoVenda(TipoItemVenda tipoItemVenda) throws DAOException {
        manager = getEntityManager();
        List<ItemVenda> lista = null;
        try {
            Query query = manager.createQuery("SELECT iv FROM ItemVenda iv WHERE iv.tipoItemVenda = :tipoItemVenda", ItemVenda.class);
            query.setParameter("tipoItemVenda", tipoItemVenda);
            lista = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return lista;
    }
}
