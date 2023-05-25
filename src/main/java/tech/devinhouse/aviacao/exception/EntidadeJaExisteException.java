package tech.devinhouse.aviacao.exception;

public class EntidadeJaExisteException extends RuntimeException{

    public EntidadeJaExisteException(String identificadorEntidade) {
        super("Entidade com o CPF " + identificadorEntidade + " já existe!");
    }

}
