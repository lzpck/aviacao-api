package tech.devinhouse.aviacao.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.aviacao.exception.EntidadeNaoEncontradaException;
import tech.devinhouse.aviacao.model.Passageiro;
import tech.devinhouse.aviacao.service.PassageiroService;
import tech.devinhouse.aviacao.web.PassageiroResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<PassageiroResponse>> getAllPassageiros() {
        List<PassageiroResponse> passageiros = passageiroService.getAllPassageiros();
        return ResponseEntity.ok(passageiros);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PassageiroResponse> getPassageiroByCpf(@PathVariable Long cpf) {
        Passageiro passageiro = this.passageiroService.consultarPorCpf(cpf)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Passageiro"));

        PassageiroResponse response = this.passageiroService.toPassageiroResponse(passageiro);

        return ResponseEntity.ok(response);
    }
}
