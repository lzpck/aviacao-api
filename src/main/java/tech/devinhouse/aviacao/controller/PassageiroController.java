package tech.devinhouse.aviacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.aviacao.model.Passageiro;
import tech.devinhouse.aviacao.service.PassageiroService;

import java.util.List;

@RestController
@RequestMapping("/api/passageiros")
public class PassageiroController {

    private final PassageiroService passageiroService;

    @Autowired
    public PassageiroController(PassageiroService passageiroService) {
        this.passageiroService = passageiroService;
    }

    @GetMapping
    public ResponseEntity<List<Passageiro>> getTodosPassageiros() {
        List<Passageiro> passageiros = passageiroService.getTodosPassageiros();
        return ResponseEntity.ok(passageiros);
    }
}
