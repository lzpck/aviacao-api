package tech.devinhouse.aviacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.aviacao.repository.ConfirmacaoRepository;

@Service
public class ConfirmacaoService {

    private final ConfirmacaoRepository confirmacaoRepository;

    @Autowired
    public ConfirmacaoService(ConfirmacaoRepository confirmacaoRepository) {
        this.confirmacaoRepository = confirmacaoRepository;
    }
}
