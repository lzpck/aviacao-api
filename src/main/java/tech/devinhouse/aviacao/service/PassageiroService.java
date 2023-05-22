package tech.devinhouse.aviacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.aviacao.model.Passageiro;
import tech.devinhouse.aviacao.repository.PassageiroRepository;

import java.util.List;

@Service
public class PassageiroService {

    private final PassageiroRepository passageiroRepository;

    @Autowired
    public PassageiroService(PassageiroRepository passageiroRepository) {
        this.passageiroRepository = passageiroRepository;
    }

    public List<Passageiro> getTodosPassageiros() {
        return passageiroRepository.findAll();
    }
}
