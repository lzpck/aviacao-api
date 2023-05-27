package tech.devinhouse.aviacao.exception;

public class AssentoEmergenciaNaoPermitidoException extends RuntimeException {

    public AssentoEmergenciaNaoPermitidoException() {
        super("Não é possível reservar fileiras de emergência para menores de idade ou sem despachar malas");
    }

}
