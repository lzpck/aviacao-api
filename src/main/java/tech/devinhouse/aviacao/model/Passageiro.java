package tech.devinhouse.aviacao.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getMilhas() {
        return milhas;
    }

    public void setMilhas(Integer milhas) {
        this.milhas = milhas;
    }
}
