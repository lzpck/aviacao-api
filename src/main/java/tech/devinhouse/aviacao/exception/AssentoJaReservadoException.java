package tech.devinhouse.aviacao.exception;

public class AssentoJaReservadoException extends RuntimeException{

    public AssentoJaReservadoException(String assento) {
        super("Assento " + assento + " já foi reservado!");
    }
}
