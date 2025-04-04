package br.com.farmacia.enums;

public enum Funcao {
    CAIXA("Caixa"),
    FARMACEUTICO("Farmacêutico"),
    GERENTE("Gerente"),
    ATENDENTE("Atendente");

    private final String descricao;

    Funcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Funcao fromDescricao(String descricao) {
        for (Funcao f : values()) {
            if (f.descricao.equalsIgnoreCase(descricao.trim())) {
                return f;
            }
        }
        throw new IllegalArgumentException("Função desconhecida: " + descricao);
    }

    @Override
    public String toString() {
        return descricao;
    }
}
