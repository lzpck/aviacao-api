package tech.devinhouse.aviacao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.aviacao.model.Confirmacao;
import tech.devinhouse.aviacao.service.ConfirmacaoService;
import tech.devinhouse.aviacao.web.ConfirmacaoRequest;
import tech.devinhouse.aviacao.web.ConfirmacaoResponse;

import java.net.URI;

@RestController
@RequestMapping("/api/passageiros")
public class ConfirmacaoController {

    private final ConfirmacaoService confirmacaoService;

    public ConfirmacaoController(ConfirmacaoService confirmacaoService) {
        this.confirmacaoService = confirmacaoService;
    }

    @PostMapping("/confirmacao")
    public ResponseEntity<ConfirmacaoResponse> registrarConfirmacao(@RequestBody ConfirmacaoRequest request) {
        try {
            Confirmacao confirmacao = confirmacaoService.registrarConfirmacao(request.getCpf(), request.getAssento(), request.isMalasDespachadas());
            ConfirmacaoResponse response = new ConfirmacaoResponse(confirmacao.geteTicket(), confirmacao.getDataHoraConfirmacao());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
