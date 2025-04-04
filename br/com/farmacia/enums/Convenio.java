package br.com.farmacia.enums;

public enum Convenio {
    PLANO_BEM("Plano Bem"),
    SAUDE_TOTAL("Saúde Total"),
    UNIMED("Unimed"),
    NAO_POSSUI("Não possui");

    private final String descricao;

    Convenio(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Convenio fromDescricao(String descricao) {
        for (Convenio convenio : values()) {
            if (convenio.getDescricao().equalsIgnoreCase(descricao.trim())) {
                return convenio;
            }
        }
        throw new IllegalArgumentException("Convênio desconhecido: " + descricao);
    }

    public boolean possuiConvenio() {
        return this != NAO_POSSUI;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
