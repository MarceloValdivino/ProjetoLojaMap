/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.dao;

import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.factory.JPAUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcelo
 */
public class GenericDaoImp<T> implements IGenericDao<T> {

    private Class clazz;
    private EntityManager manager;

    public GenericDaoImp() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void save(T o) throws DAOException {
        manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(o);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao salvar objeto no banco de dados.");
        } finally {
            manager.close();
        }
    }

    @Override
    public T update(T o) throws DAOException {
        manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            o = manager.merge(o);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao atualizar objeto no banco de dados.");
        } finally {
            manager.close();
        }
        return o;
    }

    @Override
    public void remove(T o) throws DAOException {
        manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.remove(o);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao remover objeto no banco de dados.");
        } finally {
            manager.close();
        }
    }

    @Override
    public T getById(Long id) throws DAOException {
        T c = null;
        manager = getEntityManager();
        try {
            Session session = (Session) manager.getDelegate();
            Criteria criteria = session.createCriteria(clazz);
            criteria.add(Restrictions.eq("id", id));
            c = (T) criteria.uniqueResult();
            session.close();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao buscar objeto no banco de dados.");
        }
        return c;
    }

    @Override
    public List<T> list() throws DAOException {
        List<T> lista = null;
        manager = getEntityManager();
        try {
            Session session = (Session) manager.getDelegate();
            Criteria criteria = session.createCriteria(clazz);
            lista = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            // Mudar para arquivos de Propriedades
            throw new DAOException("Erro ao listar objetos no banco de dados.");
        }
        return lista;
    }
    
    @Override
    public Criteria getCriteria() throws DAOException{
        try{
            return ((Session) manager.getDelegate()).createCriteria(clazz);
        } catch(Exception e){
            e.printStackTrace();
            throw new DAOException("Erro ao tentar criar Criteria");
        }
    }
    
    @Override
    public EntityManager getEntityManager() throws DAOException {
        try{
            manager = JPAUtil.getEntityManager();
        } catch (Exception e){
            e.printStackTrace();
            throw new DAOException("Erro ao criar EntityManager");
        }
        return manager;
    }
}
