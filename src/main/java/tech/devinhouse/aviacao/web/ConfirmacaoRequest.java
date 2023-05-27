package tech.devinhouse.aviacao.web;

public class ConfirmacaoRequest {

    private Long cpf;
    private String assento;
    private boolean malasDespachadas;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public boolean isMalasDespachadas() {
        return malasDespachadas;
    }

    public void setMalasDespachadas(boolean malasDespachadas) {
        this.malasDespachadas = malasDespachadas;
    }

}
