package tech.devinhouse.aviacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.aviacao.service.AssentoService;

import java.util.List;

@RestController
@RequestMapping("/api/assentos")
public class AssentoController {

    private final AssentoService assentoService;

    public AssentoController(AssentoService assentoService) {
        this.assentoService = assentoService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getTodosOsAssentos() {
        List<String> assentos = assentoService.getTodosOsAssentos();
        return ResponseEntity.ok(assentos);
    }
}
