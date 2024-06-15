package com.SpringValidations.controllers.dto;

import com.SpringValidations.advice.validation.anotation.ValidName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    @ValidName
    private String nombre;

    @NotBlank
    private String login;

    @NotBlank
    @Size(min = 6)
    private String pwd;

    @Valid
    private RolDTO rol;

    /*
    validadores:
    @NotNull - valores nulos
    @NotBlank - valores en blanco
    @NotEmpty - listas vacias
    @Min() - int minimo permitido
    @Max() - int maximo permitido
    @Size(min = 0, max = 0) - String minMax numero caracteres
    @pattern(regexp = ) validacion String con expresiones regulares
    @Email - valida emails
    @Digits(integer = 1,fraction = 3) - valida double
    @Past - valida fecha pasadas
    @Future - valida fecha futuras
    @AssertFalse - valida falso
    @AssertTrue - valida verdadero
    @Valid - para valdiad objetos
     */
}
