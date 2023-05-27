package tech.devinhouse.aviacao.web;

import java.time.LocalDateTime;

public class ConfirmacaoResponse {

    private String eTicket;
    private LocalDateTime dataHoraConfirmacao;

    public ConfirmacaoResponse(String eTicket, LocalDateTime dataHoraConfirmacao) {
        this.eTicket = eTicket;
        this.dataHoraConfirmacao = dataHoraConfirmacao;
    }

    public String getETicket() {
        return eTicket;
    }

    public LocalDateTime getDataHoraConfirmacao() {
        return dataHoraConfirmacao;
    }

}
