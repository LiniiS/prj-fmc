package br.com.farmacia.model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Compra {

    //AtomicInteger:
    private static final AtomicInteger contador = new AtomicInteger(0);

    private final int numeroCompra;
    private final Funcionario funcionario;
    private final Produto produto;
    private final Cliente cliente;
    private final double valorDesconto;
    private final double valorTotal;
    private final Date data;

    public Compra(Funcionario funcionario, Cliente cliente, Produto produto,
                  double valorDesconto, double valorTotal, Date data) {

        if (funcionario == null) throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        if (cliente == null) throw new IllegalArgumentException("Cliente não pode ser nulo.");
        if (produto == null) throw new IllegalArgumentException("Produto não pode ser nulo.");
        if (valorDesconto < 0) throw new IllegalArgumentException("Desconto inválido.");
        if (valorTotal < 0) throw new IllegalArgumentException("Valor total inválido.");
        if (data == null) throw new IllegalArgumentException("Data da compra não pode ser nula.");

        this.numeroCompra = contador.incrementAndGet();
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.produto = produto;
        this.valorDesconto = valorDesconto;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    public int getNumeroCompra() {
        return numeroCompra;
    }

    public Produto getProduto() {
        return produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public Date getData() {
        return data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
