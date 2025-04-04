package br.com.farmacia.model;

import br.com.farmacia.enums.Convenio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String nomeCompleto;

    //Mais moderna que o Date e Calendar
    private final LocalDate dataNascimento;
    private final String documento;
    private final String telefone;
    private final String email;
    private final String endereco;
    private final Convenio convenio;
    private final boolean aceitaPromocoes;
    private final List<Produto> produtos;

    public Cliente(
            String nomeCompleto,
            LocalDate dataNascimento,
            String documento,
            String telefone,
            String email,
            String endereco,
            Convenio convenio,
            boolean aceitaPromocoes
    ) {
        if (nomeCompleto == null || nomeCompleto.isBlank())
            throw new IllegalArgumentException("Nome inválido.");
        if (documento == null || documento.isBlank())
            throw new IllegalArgumentException("Documento inválido.");
        if (telefone == null || telefone.isBlank())
            throw new IllegalArgumentException("Telefone inválido.");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("E-mail inválido.");
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Data de nascimento inválida.");

        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.convenio = convenio;
        this.aceitaPromocoes = aceitaPromocoes;
        this.produtos = new ArrayList<>();
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public boolean temConvenio() {
        return convenio != Convenio.NAO_POSSUI;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }
}
