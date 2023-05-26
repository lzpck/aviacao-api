package tech.devinhouse.aviacao.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.aviacao.exception.EntidadeJaExisteException;
import tech.devinhouse.aviacao.exception.EntidadeNaoEncontradaException;
import tech.devinhouse.aviacao.model.Confirmacao;
import tech.devinhouse.aviacao.model.Passageiro;
import tech.devinhouse.aviacao.repository.ConfirmacaoRepository;
import tech.devinhouse.aviacao.repository.PassageiroRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ConfirmacaoService {

    @Autowired
    private ConfirmacaoRepository confirmacaoRepository;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private AssentoService assentoService;

    private static final Logger LOG = Logger.getLogger(ConfirmacaoService.class.getName());

    @Autowired
    public ConfirmacaoService(ConfirmacaoRepository confirmacaoRepository) {
        this.confirmacaoRepository = confirmacaoRepository;
    }

    public Confirmacao registrarConfirmacao(Long cpf, String assento, boolean malasDespachadas) {
        Passageiro passageiro = passageiroRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Passageiro não encontrado(a)!"));

        if (!assentoService.isAssentoExistente(assento)) {
            throw new RuntimeException("Assento não existente!");
        }

        if (confirmacaoRepository.findByAssento(assento).isPresent()) {
            throw new RuntimeException("Assento já reservado!");
        }

        if (assentoService.isFileiraEmergencia(assento) && (passageiro.isMenorDeIdade() || !malasDespachadas)) {
            throw new RuntimeException("Não é possível reservar fileiras de emergência para menores de idade ou sem despachar malas");
        }

        Confirmacao confirmacao = new Confirmacao(assento, malasDespachadas, passageiro);
        passageiro.adicionarMilhas(confirmacao);
        confirmacaoRepository.save(confirmacao);

        LOG.log(Level.INFO, "Confirmação feita pelo passageiro de CPF {0} com e-ticket {1}", new Object[]{cpf, confirmacao.geteTicket()});


        return confirmacao;
    }
}
