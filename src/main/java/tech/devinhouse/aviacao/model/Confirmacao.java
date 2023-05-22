package tech.devinhouse.aviacao.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Confirmacao {

    @Id
    private String eTicket;
    private String assento;
    private Boolean malasDespachadas;
    private LocalDateTime dataHoraConfirmacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_passageiro")
    private Passageiro passageiro;

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

    public Boolean getMalasDespachadas() {
        return malasDespachadas;
    }

    public void setMalasDespachadas(Boolean malasDespachadas) {
        this.malasDespachadas = malasDespachadas;
    }

    public LocalDateTime getDataHoraConfirmacao() {
        return dataHoraConfirmacao;
    }

    public void setDataHoraConfirmacao(LocalDateTime dataHoraConfirmacao) {
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }
}
