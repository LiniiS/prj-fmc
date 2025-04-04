package br.com.farmacia.model;

import br.com.farmacia.enums.Funcao;

public class Funcionario {
    private final String nome;
    private final Funcao funcao;

    public Funcionario(String nome, Funcao funcao) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do funcionário inválido.");
        }
        if (funcao == null) {
            throw new IllegalArgumentException("Função não pode ser nula.");
        }

        this.nome = nome;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public boolean isOperadorCaixa() {
        return funcao == Funcao.CAIXA;
    }
}
