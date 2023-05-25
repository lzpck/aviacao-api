package tech.devinhouse.aviacao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Passageiro {

    @Id
    private Long cpf;

    private String nome;

    private LocalDate dataDeNascimento;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    private Integer milhas;

    @OneToMany(mappedBy = "passageiro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Confirmacao> confirmacoes;

    public Passageiro(Long cpf, String nome, LocalDate dataDeNascimento, Classificacao classificacao, Integer milhas, List<Confirmacao> confirmacoes) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.classificacao = classificacao;
        this.milhas = milhas;
        this.confirmacoes = confirmacoes;
    }

    public Passageiro(Long cpf, String nome, LocalDate dataDeNascimento, Integer milhas, List<Confirmacao> confirmacoes) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.milhas = milhas;
        this.confirmacoes = confirmacoes;
        atualizarClassificacao();
    }

    private void atualizarClassificacao() {
        if (milhas >= 10000) {
            this.classificacao = Classificacao.VIP;
        } else if (milhas >= 7500) {
            this.classificacao = Classificacao.OURO;
        } else if (milhas >= 5000) {
            this.classificacao = Classificacao.PRATA;
        } else if (milhas >= 2500) {
            this.classificacao = Classificacao.BRONZE;
        } else {
            this.classificacao = Classificacao.ASSOCIADO;
        }
    }
}