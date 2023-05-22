package tech.devinhouse.aviacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.devinhouse.aviacao.repository.PassageiroRepository;

@Service
public class PassageiroService {

    private final PassageiroRepository passageiroRepository;

    @Autowired
    public PassageiroService(PassageiroRepository passageiroRepository) {
        this.passageiroRepository = passageiroRepository;
    }
}
