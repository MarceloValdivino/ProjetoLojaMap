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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class ParcelaAVista implements IGeradorParcelasStrategy {

    @Override
    public List<Parcela> geradorParcelas(Double valorTotal, int quantidadeParcelas, TipoPagamento tipoPagamento, Funcionario funcionario, ConfiguracaoPagamento formaPagamento) {
        
        if(formaPagamento.getTipoPagamento() == TipoPagamento.A_VISTA){
            valorTotal = valorTotal - (valorTotal * 0.15);
        }
        
        List<Parcela> listaParcelas = new ArrayList<>();
        
        Parcela parcela = new Parcela();
        parcela.getPagamento().setJuros(formaPagamento.getMulta());
        parcela.getPagamento().setMulta(formaPagamento.getMulta());
        parcela.getPagamento().setDataPagamento(Calendar.getInstance());
        parcela.getPagamento().setPago(true);
        parcela.getPagamento().setValorPago(valorTotal);
        parcela.setVencimanto(Calendar.getInstance());
        parcela.setValorParcela(valorTotal);
        listaParcelas.add(parcela);
        
        return listaParcelas;
    }

    
}
