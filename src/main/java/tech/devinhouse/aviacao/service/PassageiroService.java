package tech.devinhouse.aviacao.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.devinhouse.aviacao.exception.EntidadeJaExisteException;
import tech.devinhouse.aviacao.model.Confirmacao;
import tech.devinhouse.aviacao.model.Passageiro;
import tech.devinhouse.aviacao.repository.PassageiroRepository;
import tech.devinhouse.aviacao.web.PassageiroResponse;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassageiroService {

    private final PassageiroRepository passageiroRepository;

    public Passageiro salvar(Passageiro passageiro) {
        Optional<Passageiro> optionalPassageiro = passageiroRepository.findById(passageiro.getCpf());
        if (optionalPassageiro.isPresent())
            throw new EntidadeJaExisteException("Passageiro");

        Passageiro save = passageiroRepository.save(passageiro);
        return save;
    }

    public List<Passageiro> consultar() {
        return passageiroRepository.findAll();
    }

    public List<PassageiroResponse> getAllPassageiros() {
        List<Passageiro> passageiros = passageiroRepository.findAll();
        return passageiros.stream()
                .map(this::toPassageiroResponse)
                .collect(Collectors.toList());
    }

    public PassageiroResponse toPassageiroResponse(Passageiro passageiro) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        PassageiroResponse response = new PassageiroResponse();
        response.setCpf(passageiro.getCpf());
        response.setNome(passageiro.getNome());
        response.setDataNascimento(passageiro.getDataDeNascimento().format(dateFormatter));
        response.setClassificacao(passageiro.getClassificacao().name());
        response.setMilhas(passageiro.getMilhas());

        Confirmacao confirmacao = passageiro.getConfirmacoes().isEmpty() ? null : passageiro.getConfirmacoes().get(0);
        if (confirmacao != null) {
            response.seteTicket(confirmacao.geteTicket());
            response.setAssento(confirmacao.getAssento());
            response.setDataHoraConfirmacao(confirmacao.getDataHoraConfirmacao().format(dateTimeFormatter));
        }

        return response;
    }

    public Optional<Passageiro> consultarPorCpf(Long cpf) {
        return passageiroRepository.findById(cpf);
    }
}

