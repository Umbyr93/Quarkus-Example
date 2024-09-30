package it.urusso.model.dto;

public record UserDto(
    Long id,
    String name,
    String surname,
    String fiscalCode
) {}
