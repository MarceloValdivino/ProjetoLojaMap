/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.business;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.ConfiguracaoPagamento;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IConfiguracaoPagamentoBusiness {
    
    public void salvarOuAtualizar(ConfiguracaoPagamento configuracaoPagamento) throws BusinessException;

    public void remover(ConfiguracaoPagamento configuracaoPagamento) throws BusinessException;
    
    public void remover(List<ConfiguracaoPagamento> configuracaoPagamento) throws BusinessException;

    public ConfiguracaoPagamento getById(Long id) throws BusinessException;

    public List<ConfiguracaoPagamento> listar() throws BusinessException;
}
