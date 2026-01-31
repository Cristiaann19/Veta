package com.example.vet.Model.GestionMedica;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vacunas")
public class VacunaCatalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fabricante;
    private String enfermedadAsociada;
    private Integer edadRecomendada;
    private Integer dosis;
    private Double precio;
}
