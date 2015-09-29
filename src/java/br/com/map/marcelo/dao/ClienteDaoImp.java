/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.dao;

import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.entidades.Cliente;
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
public class ClienteDaoImp extends GenericDaoImp<Cliente> implements IClienteDao {

    private EntityManager manager;
    
    @Override
    public List<Cliente> listPorNome(String nome) throws DAOException {
        List<Cliente> lista = null;
        manager = getEntityManager();
        try{
            Criteria criteria = this.getCriteria();
            criteria.add(Restrictions.like("nome", "%"+nome+"%").ignoreCase());
            lista = criteria.list();
        } catch (Exception e){
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return lista;
    }

    @Override
    public List<Cliente> listPorBusca(String busca) throws DAOException {
        List<Cliente> lista = null;
        manager = getEntityManager();
        try{
            Criteria criteria = this.getCriteria();
            criteria.add(Restrictions.like("nome", "%"+busca+"%").ignoreCase());
            criteria.add(Restrictions.like("cpf", "%"+busca+"%"));
            lista = criteria.list();
        } catch (Exception e){
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return lista;
    }

    @Override
    public Cliente getPorCpf(String cpf) throws DAOException {
        Cliente c = null;
        try {
            manager = this.getEntityManager();
            Criteria criteria = this.getCriteria();
            criteria.add(Restrictions.eq("cpf", cpf));
            c = (Cliente) criteria.uniqueResult();
        } catch (Exception e){
            manager.getTransaction().rollback();
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return c;
    }

    @Override
    public List<Cliente> listarPorCompra(ItemProduto itemProduto) throws DAOException {
        manager = getEntityManager();
        List<Cliente> lista = null;
        try{
            Query query = manager.createNativeQuery("select c.* from cliente c where c.id in (select v.cliente_id from venda v, venda_itemvenda viv where viv.venda_id = v.id AND viv.itens_id in (select iv.id from itemvenda iv, itemproduto ip where iv.itemproduto_id = ip.id AND ip.id = :idItemProduto))", Cliente.class);
            query.setParameter("idItemProduto", itemProduto.getId());
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
