package it.urusso.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final String code;
    private final String message;

    public BusinessException(ErrorMessage e) {
        this.code = e.getCode();
        this.message = e.getMessage();
    }
}
