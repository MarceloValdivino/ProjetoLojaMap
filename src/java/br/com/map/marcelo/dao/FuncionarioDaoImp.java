/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.dao;

import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.factory.JPAUtil;
import com.sun.faces.config.WebConfiguration;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcelo
 */
public class FuncionarioDaoImp extends GenericDaoImp<Funcionario> implements IFuncionarioDao {

    private EntityManager manager;

    @Override
    public List<Funcionario> listarPorVenderDesconto(boolean desconto) throws DAOException {
        manager = getEntityManager();
        List<Funcionario> lista = null;
        try {
            Criteria criteria = this.getCriteria();
            criteria.add(Restrictions.eq("desconto", desconto));
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
    public List<Funcionario> listarPorStatus(boolean status) throws DAOException {
        manager = getEntityManager();
        List<Funcionario> lista = null;
        try {
            Criteria criteria = getCriteria();
            criteria.add(Restrictions.eq("status", status));
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
    public Funcionario getByCpf(String cpf) throws DAOException {
        manager = getEntityManager();
        Funcionario funcionario = null;
        try {
            Criteria criteria = getCriteria();
            criteria.add(Restrictions.eq("cpf", cpf));
            funcionario = (Funcionario) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException(e.getMessage());
        } finally {
            manager.close();
        }
        return  funcionario;
    }

}
