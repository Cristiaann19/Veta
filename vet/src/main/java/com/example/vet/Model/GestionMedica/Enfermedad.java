package com.example.vet.Model.GestionMedica;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "enfermedades")
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 2, max = 255, message = "La descripción debe tener entre 2 y 255 caracteres")
    @Column(nullable = false, length = 255)
    private String descripcion;

    @NotBlank(message = "La especie es obligatoria")
    @Size(min = 2, max = 100, message = "La especie debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String especie;

    @NotBlank(message = "La gravedad es obligatoria")
    @Size(min = 2, max = 100, message = "La gravedad debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String gravedad;
}
