package br.com.coti.contregastohinode.model;

public class Produto {

    private long idProduto;
    private String nomeProduto;
    private Double valorVenda;

    public Produto(long idProduto, String nomeProduto, Double valorVenda) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorVenda = valorVenda;
    }

    public Produto() {
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return nomeProduto;
    }
}
