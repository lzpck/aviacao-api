package tech.devinhouse.aviacao.web;

import java.util.Map;

public class ErroResponse {

    private String mensagem;

    private Map<String, String> detalhes;

    public ErroResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public ErroResponse(String mensagem, Map<String, String> details) {
        this(mensagem);
        this.detalhes = details;
    }
}
