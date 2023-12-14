package br.com.infnet.exceptions;

public class ValorInvalidoException extends RuntimeException {
    public ValorInvalidoException(String mensagem) {
            super(mensagem);
        }
}
