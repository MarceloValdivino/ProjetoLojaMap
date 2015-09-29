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
import br.com.map.marcelo.entidades.Venda;
import br.com.map.marcelo.enums.TipoItemVenda;
import br.com.map.marcelo.enums.TipoPagamento;
import br.com.map.marcelo.utils.DateUtil;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcelo
 */
public class VendaDaoImp extends GenericDaoImp<Venda> implements IVendaDao {

    private EntityManager manager;

    @Override
    public List<Venda> listarPorPeriodo(Calendar dataInicial, Calendar dataFinal) throws DAOException {
        manager = getEntityManager();
        List<Venda> lista = null;
        try {
            Criteria criteria = getCriteria();
            criteria.add(Restrictions.between("dataVenda", dataInicial, dataFinal));
            lista = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return lista;
    }

    @Override
    public List<Venda> listarPorCompraCliente(Cliente cliente) throws DAOException {
        manager = getEntityManager();
        List<Venda> lista = null;
        try {
            Criteria criteria = getCriteria();
            criteria.add(Restrictions.eq("cliente", cliente));
            lista = criteria.list();
        } catch (DAOException | HibernateException e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return lista;
    }

    @Override
    public List<Venda> listarPorTipoPagamento(TipoPagamento tipoPagamento) throws DAOException {
        manager = getEntityManager();
        List<Venda> lista = null;
        try {
            Criteria criteria = getCriteria();
            criteria.add(Restrictions.eq("tipoPagamento", tipoPagamento));
            lista = criteria.list();
        } catch (DAOException | HibernateException e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return lista;
    }

    @Override
    public List<Venda> listarPorItemProduto(ItemProduto itemProduto) throws DAOException {
        manager = getEntityManager();
        List<Venda> lista = null;
        try {
            Query query = manager.createNativeQuery("select v.* from venda v, venda_itemvenda viv where viv.venda_id = v.id AND viv.itens_id in (select iv.id from itemvenda iv, itemproduto ip where iv.itemproduto_id = ip.id AND ip.id = :idItemProduto)", Venda.class);
            query.setParameter("idItemProduto", itemProduto.getId());
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
    public List<Venda> listarVendasComDesconto(boolean desconto) throws DAOException {
        manager = getEntityManager();
        List<Venda> lista = null;
        try {
            Query query = manager.createQuery("SELECT v FROM Venda v, ItemVenda iv WHERE iv.desconto = :desconto AND iv MEMBER OF v.itens", Venda.class);
            query.setParameter("desconto", desconto);
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
    public List<Venda> listaVendasPorFuncionario(Funcionario funcionario) throws DAOException {
        manager = getEntityManager();
        List<Venda> lista = null;
        try {
            Query query = manager.createQuery("SELECT v FROM Venda v WHERE v.funcionario = :funcionario", Venda.class);
            query.setParameter("funcionario", funcionario);
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
    public double aputadoMes(Calendar dataInicial, Calendar dataFinal) throws DAOException {
        manager = getEntityManager();
        double valor = 0;
        try {
            Criteria criteria = getCriteria();
            criteria.add(Restrictions.between("dataVenda", dataInicial, dataFinal));
            criteria.setProjection(Projections.sum("precoTotal"));
            if (criteria.uniqueResult() != null) {
                valor = (double) criteria.uniqueResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return valor;
    }
}
