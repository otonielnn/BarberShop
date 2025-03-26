package br.com.dio.barbershop.exception;

public class EmailInUseException extends RuntimeException {
    
    public EmailInUseException(String message) {
        super(message);
    }
}
