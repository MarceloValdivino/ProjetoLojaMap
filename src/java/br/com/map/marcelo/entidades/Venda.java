/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.entidades;

import br.com.map.marcelo.commom.strategy.IGeradorParcelasStrategy;
import br.com.map.marcelo.enums.TipoItemVenda;
import br.com.map.marcelo.enums.TipoPagamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Marcelo
 */
@Entity
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemVenda> itens;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataVenda;
    private Double precoTotal;
    @OneToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;
    private TipoPagamento tipoPagamento;
    private int quantidadeParcelas;
    @OneToMany
    private List<Parcela> parcelas;
    @ManyToOne
    private ConfiguracaoPagamento configuracaoPagamento;
    @Transient
    private IGeradorParcelasStrategy geradorParcelasStrategy;

    public Venda() {
        itens = new ArrayList<>();
        configuracaoPagamento = new ConfiguracaoPagamento();
        parcelas = new ArrayList<>();
        quantidadeParcelas = 1;
        dataVenda = Calendar.getInstance();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public Calendar getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public ConfiguracaoPagamento getConfiguracaoPagamento() {
        return configuracaoPagamento;
    }

    public void setConfiguracaoPagamento(ConfiguracaoPagamento configuracaoPagamento) {
        this.configuracaoPagamento = configuracaoPagamento;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public IGeradorParcelasStrategy getGeradorParcelasStrategy() {
        return geradorParcelasStrategy;
    }

    public void setGeradorParcelasStrategy(IGeradorParcelasStrategy geradorParcelasStrategy) {
        this.geradorParcelasStrategy = geradorParcelasStrategy;
    }
    
    public void gerarParcelas(){
        this.parcelas = geradorParcelasStrategy.geradorParcelas(precoTotal, quantidadeParcelas, tipoPagamento, funcionario, configuracaoPagamento);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", itens=" + itens + ", dataVenda=" + dataVenda + ", precoTotal=" + precoTotal + ", cliente=" + cliente + ", funcionario=" + funcionario + ", tipoPagamento=" + tipoPagamento + ", quantidadeParcelas=" + quantidadeParcelas + ", parcelas=" + parcelas + ", configuracaoPagamento=" + configuracaoPagamento + ", geradorParcelas=" + geradorParcelasStrategy + '}';
    }
}
