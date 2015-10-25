/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.commom.strategy;

import br.com.map.marcelo.entidades.ConfiguracaoPagamento;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.entidades.Parcela;
import br.com.map.marcelo.enums.TipoPagamento;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public interface IGeradorParcelasStrategy {
    
    public List<Parcela> geradorParcelas(Double valorTotal, int quantidadeParcelas, TipoPagamento tipoPagamento, Funcionario funcionario, ConfiguracaoPagamento configuracaoPagamento);
}
