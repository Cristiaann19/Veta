// CitaResponseDTO.java
package com.example.vet.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CitaDTO {
    private Long id;
    private LocalDateTime fechaHora;
    private String servicioNombre;
    private Double precioAcordado;
    private String motivo;
    private String estado;

    // Mascota
    private Long mascotaId;
    private String mascotaNombre;

    // Cliente (dueño de la mascota)
    private Long clienteId;
    private String clienteNombre;    // nombre completo del dueño

    // Trabajador
    private Long trabajadorId;
    private String trabajadorNombre; // nombre completo del trabajador
}