package io.github.robertoaraujo.rest.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class UsuarioDTO {
    @NotNull
    @Size(min = 2, max = 50)
    private String nome;

    @NotBlank
    @Email
    private String email;

    @Past
    private LocalDate dataNascimento;

    @Min(18)
    @Max(65)
    private int idade;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String username;

    @AssertTrue
    private boolean aceitouTermos;
}
