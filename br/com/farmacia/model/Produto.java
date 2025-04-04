package br.com.farmacia.model;

import br.com.farmacia.enums.Categoria;

import java.time.LocalDate;
import java.util.Date;

public class Produto {
    private String nome;
    private Categoria categoria;
    private double preco;
    private int quantidade;
    private LocalDate dataUltimaAquisicao;
    private String fornecedor;

    public Produto(String nome, Categoria categoria, double preco, int quantidade, LocalDate dataUltimaAquisicao, String fornecedor) {
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome inválido.");
        if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo.");
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade inválida.");
        if (fornecedor == null || fornecedor.isEmpty()) throw new IllegalArgumentException("Fornecedor inválido.");

        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataUltimaAquisicao = dataUltimaAquisicao;
        this.fornecedor = fornecedor;
    }

    public void reduzirEstoque(int quantidadeVendida) {
        if (quantidadeVendida > this.quantidade) {
            throw new IllegalArgumentException("Estoque insuficiente.");
        }
        this.quantidade -= quantidadeVendida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataUltimaAquisicao() {
        return dataUltimaAquisicao;
    }

    public void setDataUltimaAquisicao(LocalDate dataUltimaAquisicao) {
        this.dataUltimaAquisicao = dataUltimaAquisicao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
