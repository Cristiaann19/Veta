package com.example.vet.Model.GestionVentas;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String descripcion;
    private String icono;
    private Double precio;

    @Enumerated(EnumType.STRING)
    private EstadoServicio estado = EstadoServicio.ACTIVO;

    public enum EstadoServicio{
        ACTIVO, INACTIVO
    }
}
