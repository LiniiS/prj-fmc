package br.com.farmacia.enums;

public enum Categoria {
    MEDICAMENTO("Medicamento"),
    SKIN_CARE("Skin Care"),
    HIGIENE_PESSOAL("Higiene Pessoal"),
    UTILIDADES("Utilidades"),
    OUTRA("Outra");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Categoria fromDescricao(String descricao) {
        for (Categoria c : values()) {
            if (c.descricao.equalsIgnoreCase(descricao.trim())) {
                return c;
            }
        }
        throw new IllegalArgumentException("Categoria desconhecida: " + descricao);
    }

    @Override
    public String toString() {
        return descricao;
    }
}
