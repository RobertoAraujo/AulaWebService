package io.github.robertoaraujo.rest;

public class ApiErrors {
    private String message;

    public ApiErrors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
