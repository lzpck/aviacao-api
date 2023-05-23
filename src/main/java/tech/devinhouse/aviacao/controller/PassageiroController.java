package tech.devinhouse.aviacao.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.aviacao.model.Passageiro;
import tech.devinhouse.aviacao.service.PassageiroService;
import tech.devinhouse.aviacao.web.PassageiroResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/passageiros")
public class PassageiroController {

    private ModelMapper mapper;
    private PassageiroResponse passageiroResponse;

    private final PassageiroService passageiroService;

    @Autowired
    public PassageiroController(PassageiroService passageiroService) {
        this.passageiroService = passageiroService;
        this.mapper = new ModelMapper();
    }

    @GetMapping
    public ResponseEntity<List<PassageiroResponse>> getTodosPassageiros() {
        List<Passageiro> passageiros = passageiroService.getTodosPassageiros();
        List<PassageiroResponse> passageirosResponse = new ArrayList<>();
        for (Passageiro passageiro : passageiros) {
            passageiroResponse = mapper.map(passageiro, PassageiroResponse.class);
            passageirosResponse.add(passageiroResponse);
        }
        return ResponseEntity.ok(passageirosResponse);
    }
}
