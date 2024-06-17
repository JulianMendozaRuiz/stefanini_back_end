package com.julian_mendoza.stefanini_back_end.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class ClientDTO {

    @NotNull
    private String tipo_de_documento;
    @NotNull
    private String numero_documento;
    @NotNull
    private String primer_nombre;
    @NotNull
    private String segundo_nombre;
    @NotNull
    private String primer_apellido;
    @NotNull
    private String segundo_apellido;
    @NotNull
    private String telefono;
    @NotNull
    private String direccion;
    @NotNull
    private String ciudad_de_residencia;

}
