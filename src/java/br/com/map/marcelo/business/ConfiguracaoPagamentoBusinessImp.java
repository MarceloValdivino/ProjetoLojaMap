/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.commom.exception.DAOException;
import br.com.map.marcelo.dao.ConfiguracaoPagamentoDaoImp;
import br.com.map.marcelo.entidades.ConfiguracaoPagamento;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class ConfiguracaoPagamentoBusinessImp implements IConfiguracaoPagamentoBusiness {

    private ConfiguracaoPagamentoDaoImp configuracaoPagamentoDaoImp;

    public ConfiguracaoPagamentoBusinessImp() {
        configuracaoPagamentoDaoImp = new ConfiguracaoPagamentoDaoImp();
    }

    @Override
    public void salvarOuAtualizar(ConfiguracaoPagamento configuracaoPagamento) throws BusinessException {
        try {
            if (configuracaoPagamento.getId() != null) {
                configuracaoPagamentoDaoImp.update(configuracaoPagamento);
            } else {
                configuracaoPagamentoDaoImp.save(configuracaoPagamento);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(ConfiguracaoPagamento configuracaoPagamento) throws BusinessException {
        try {
            configuracaoPagamentoDaoImp.remove(configuracaoPagamento);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void remover(List<ConfiguracaoPagamento> configuracaoPagamento) throws BusinessException {
        try {
            for (ConfiguracaoPagamento cp : configuracaoPagamento) {
                configuracaoPagamentoDaoImp.remove(cp);
            }
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public ConfiguracaoPagamento getById(Long id) throws BusinessException {
        ConfiguracaoPagamento c = null;
        try {
            c = configuracaoPagamentoDaoImp.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        return c;
    }

    @Override
    public List<ConfiguracaoPagamento> listar() throws BusinessException {
        try {
            return configuracaoPagamentoDaoImp.list();
        } catch (DAOException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }

    }

}
