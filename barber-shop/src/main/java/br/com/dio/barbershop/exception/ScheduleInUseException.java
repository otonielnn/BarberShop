package br.com.dio.barbershop.exception;

public class ScheduleInUseException extends RuntimeException{
    
    public ScheduleInUseException(String message) {
        super(message);
    }
}
