package it.urusso.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    ID_NULL("QK_001", "ID cannot be null");

    private final String code;
    private final String message;

    ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
