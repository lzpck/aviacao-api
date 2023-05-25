package tech.devinhouse.aviacao.web;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PassageiroResponse {

    private Long cpf;
    private String nome;
    private String dataNascimento;
    private String classificacao;
    private Integer milhas;
    private String eTicket;
    private String assento;
    private String dataHoraConfirmacao;

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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getMilhas() {
        return milhas;
    }

    public void setMilhas(Integer milhas) {
        this.milhas = milhas;
    }

    public String geteTicket() {
        return eTicket;
    }

    public void seteTicket(String eTicket) {
        this.eTicket = eTicket;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getDataHoraConfirmacao() {
        return dataHoraConfirmacao;
    }

    public void setDataHoraConfirmacao(String dataHoraConfirmacao) {
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }
}
