package tech.devinhouse.aviacao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Confirmacao {

    @Id
    private String eTicket;
    private String assento;
    private Boolean malasDespachadas;
    private LocalDateTime dataHoraConfirmacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_passageiro")
    private Passageiro passageiro;

    public Confirmacao(String assento, Boolean malasDespachadas, Passageiro passageiro) {
        this.eTicket = UUID.randomUUID().toString();
        this.assento = assento;
        this.malasDespachadas = malasDespachadas;
        this.dataHoraConfirmacao = LocalDateTime.now();
        this.passageiro = passageiro;
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

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
}
