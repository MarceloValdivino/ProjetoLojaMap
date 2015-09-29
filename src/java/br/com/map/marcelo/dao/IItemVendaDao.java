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

/**
 *
 * @author Marcelo
 */
public interface IItemVendaDao extends IGenericDao<ItemVenda> {

    public List<ItemVenda> listarPorTipoVenda(TipoItemVenda tipoItemVenda) throws DAOException;

}
