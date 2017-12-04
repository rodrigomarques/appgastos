package br.com.coti.contregastohinode.model;

import java.util.Date;

public class Venda {

    private long idVenda;
    private Produto produto;
    private Double valor;
    private Date dataVenda;
    private Boolean isPago;
    private Date dataPagamento;

    public Venda(long idVenda, Produto produto, Double valor, Date dataVenda, Boolean isPago, Date dataPagamento) {
        this.idVenda = idVenda;
        this.produto = produto;
        this.valor = valor;
        this.dataVenda = dataVenda;
        this.isPago = isPago;
        this.dataPagamento = dataPagamento;
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Boolean getIsPago() {
        return isPago;
    }

    public void setIsPago(Boolean isPago) {
        this.isPago = isPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}


