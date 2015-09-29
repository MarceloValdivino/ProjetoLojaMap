/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.ItemVenda;
import br.com.map.marcelo.enums.TipoItemVenda;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IItemVendaBusiness {
    
    public void salvarOuAtualizar(ItemVenda itemVenda) throws BusinessException;

    public void remover(ItemVenda itemVenda) throws BusinessException;

    public ItemVenda getById(Long id) throws BusinessException;

    public List<ItemVenda> listar() throws BusinessException;
    
    public List<ItemVenda> listarPorTipoVenda(TipoItemVenda tipoItemVenda) throws BusinessException;
}
