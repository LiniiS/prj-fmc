package br.com.farmacia.model;

import br.com.farmacia.enums.Categoria;

import java.time.LocalDate;
import java.util.Date;

public class Medicamento extends Produto {
    private final String nomeCientifico;
    private final boolean medicamentoGenerico;
    private final boolean retemReceita;
    private final String formatoDose;
    private final String fabricante;
    private final Date vencimento;

    public Medicamento(
            String nome,
            double preco,
            int quantidade,
            LocalDate dataUltimaAquisicao,
            String fornecedor,
            String nomeCientifico,
            boolean medicamentoGenerico,
            boolean retemReceita,
            String formatoDose,
            String fabricante,
            Date vencimento
    ) {
        super(nome, Categoria.MEDICAMENTO, preco, quantidade, dataUltimaAquisicao, fornecedor);

        if (nomeCientifico == null || nomeCientifico.isEmpty()) {
            throw new IllegalArgumentException("Nome científico inválido.");
        }

        if (formatoDose == null || formatoDose.isEmpty()) {
            throw new IllegalArgumentException("Formato de dose inválido.");
        }

        if (fabricante == null || fabricante.isEmpty()) {
            throw new IllegalArgumentException("Fabricante inválido.");
        }

        if (vencimento == null || vencimento.before(new Date())) {
            throw new IllegalArgumentException("Data de vencimento inválida.");
        }

        this.nomeCientifico = nomeCientifico;
        this.medicamentoGenerico = medicamentoGenerico;
        this.retemReceita = retemReceita;
        this.formatoDose = formatoDose;
        this.fabricante = fabricante;
        this.vencimento = vencimento;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public boolean isMedicamentoGenerico() {
        return medicamentoGenerico;
    }

    public boolean isRetemReceita() {
        return retemReceita;
    }

    public String getFormatoDose() {
        return formatoDose;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Date getVencimento() {
        return vencimento;
    }
}
