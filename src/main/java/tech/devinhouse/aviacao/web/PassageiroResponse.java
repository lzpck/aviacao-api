package tech.devinhouse.aviacao.web;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PassageiroResponse {

    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String classificacao;
    private Integer milhas;
    private String eTicket;
    private String assento;
    private LocalDateTime dataHoraConfirmacao;

}
