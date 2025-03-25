package com.petshop.exception;

public class ServicoException extends Exception {
    public ServicoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicoException(String message) {
        super(message);
    }
}