/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.dao;

import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.entidades.ItemProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcelo
 */
public class ItemProdutoImp extends GenericDaoImp<ItemProduto> implements IItemProdutoDao {
    
    private EntityManager manager;
    
    @Override
    public List<ItemProduto> listarPorCompraCliente(Cliente cliente) throws DAOException {
        manager = getEntityManager();
        List<ItemProduto> lista = null;
        try {
            Query query = manager.createNativeQuery("SELECT ip.* FROM itemvenda iv, itemproduto ip WHERE iv.itemproduto_id = ip.id AND iv.id IN (SELECT viv.itens_id FROM venda v, venda_itemvenda viv WHERE v.cliente_id = :idCliente AND viv.venda_id = v.id)", ItemProduto.class);
            query.setParameter("idCliente", cliente.getId());
            lista = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return lista;
    }

    @Override
    public List<ItemProduto> listarVendidosPorFuncionario(Funcionario funcionario) throws DAOException {
        manager = getEntityManager();
        List<ItemProduto> lista = null;
        try{
            Query query = manager.createNativeQuery("SELECT ip.* FROM itemvenda iv, itemproduto ip WHERE iv.itemproduto_id = ip.id AND iv.id IN (SELECT viv.itens_id FROM venda v, venda_itemvenda viv WHERE v.funcionario_id = :idFuncionario AND viv.venda_id = v.id)", ItemProduto.class);
            query.setParameter("idFuncionario", funcionario);
            lista = query.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        }finally{
            manager.close();
        }
        return lista;
    }
    
    
    
}
