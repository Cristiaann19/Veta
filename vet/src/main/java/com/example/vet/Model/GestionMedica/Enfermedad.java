package com.example.vet.Model.GestionMedica;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="enfermedades")
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String especie;
    private String gravedad;
}
