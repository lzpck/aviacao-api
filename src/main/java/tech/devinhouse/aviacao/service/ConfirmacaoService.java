package tech.devinhouse.aviacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.aviacao.exception.AssentoEmergenciaNaoPermitidoException;
import tech.devinhouse.aviacao.exception.AssentoJaReservadoException;
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
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Passageiro com CPF " + cpf));

        if (!assentoService.isAssentoExistente(assento)) {
            throw new EntidadeNaoEncontradaException("Assento " + assento);
        }

        if (confirmacaoRepository.findByAssento(assento).isPresent()) {
            throw new AssentoJaReservadoException(assento);
        }

        if (assentoService.isFileiraEmergencia(assento) && (passageiro.isMenorDeIdade() || !malasDespachadas)) {
            throw new AssentoEmergenciaNaoPermitidoException();
        }

        Confirmacao confirmacao = new Confirmacao(assento, malasDespachadas, passageiro);
        passageiro.adicionarMilhas(confirmacao);
        confirmacaoRepository.save(confirmacao);

        LOG.log(Level.INFO, "Confirmação feita pelo passageiro de CPF {0} com e-ticket {1}", new Object[]{cpf, confirmacao.geteTicket()});


        return confirmacao;
    }
}
