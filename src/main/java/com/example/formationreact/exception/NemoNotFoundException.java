package com.example.formationreact.exception;

public class NemoNotFoundException extends RuntimeException {
    private final Long id;
    public NemoNotFoundException(String message, Long id) {
        super(message);
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("Nemo with id %d not found", id);
    }
}
