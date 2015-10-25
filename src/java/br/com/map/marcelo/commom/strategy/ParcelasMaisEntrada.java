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
public class ParcelasMaisEntrada implements IGeradorParcelasStrategy {

    @Override
    public List<Parcela> geradorParcelas(Double valorTotal, int quantidadeParcelas, TipoPagamento tipoPagamento, Funcionario funcionario, ConfiguracaoPagamento formaPagamento) {

        Double valorParcela = valorTotal / quantidadeParcelas;
        List<Parcela> listaParcelas = new ArrayList<>();

        for (int i = 0; i < quantidadeParcelas; i++) {
            Parcela parcela = new Parcela();
            Calendar dataVencimento = Calendar.getInstance();
            dataVencimento.add(Calendar.MONTH, i);
            parcela.getPagamento().setJuros(formaPagamento.getMulta());
            parcela.getPagamento().setMulta(formaPagamento.getMulta());
            parcela.getPagamento().setDataPagamento(Calendar.getInstance());
            parcela.getPagamento().setValorPago(valorParcela);
            parcela.setVencimanto(dataVencimento);
            parcela.setValorParcela(valorTotal);

            if (i == 0) {
                parcela.getPagamento().setPago(true);
            } else {
                parcela.getPagamento().setPago(false);
            }

            listaParcelas.add(parcela);
        }

        return listaParcelas;
    }

}
