/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.dao.FuncionarioDaoImp;
import br.com.map.marcelo.dao.IFuncionarioDao;
import br.com.map.marcelo.entidades.Funcionario;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class FuncionarioBusinessImp implements IFuncionarioBusiness {

    private IFuncionarioDao funcionarioDao;

    public FuncionarioBusinessImp() {
        funcionarioDao = new FuncionarioDaoImp();
    }

    @Override
    public void salvarOuAtualizar(Funcionario funcionario) throws BusinessException {
        try {
            if (funcionario.getId() != null) {
                funcionarioDao.update(funcionario);
            } else {
                funcionarioDao.save(funcionario);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(Funcionario funcionario) throws BusinessException {
        try {
            funcionarioDao.remove(funcionario);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(List<Funcionario> funcionarios) throws BusinessException {
        try {
            for (Funcionario funcionario : funcionarios) {
                funcionarioDao.remove(funcionario);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Funcionario getById(Long id) throws BusinessException {
        try {
            return funcionarioDao.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Funcionario> listar() throws BusinessException {
        try {
            return funcionarioDao.list();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Funcionario> listarPorVenderDesconto(boolean desconto) throws BusinessException {
        try {
            return funcionarioDao.listarPorVenderDesconto(desconto);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Funcionario> listarPorStatus(boolean status) throws BusinessException {
        try {
            return funcionarioDao.listarPorStatus(status);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Funcionario getByCpf(String cpf) throws BusinessException {
        try {
            return funcionarioDao.getByCpf(cpf);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }
}
