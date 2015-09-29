/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.dao;

import br.com.map.marcelo.commom.exception.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;

/**
 *
 * @author Marcelo
 * @param <T>
 */
public interface IGenericDao<T> {
    
    public void save(T o) throws DAOException;
    public T update(T o) throws DAOException;
    public void remove(T o) throws DAOException;
    public T getById(Long id) throws DAOException;
    public List<T> list() throws DAOException;
    public Criteria getCriteria() throws DAOException;
    public EntityManager getEntityManager() throws DAOException;
}
