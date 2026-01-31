package com.example.vet.Model.GestionUsuarios;

import java.time.LocalDateTime;

import com.example.vet.Model.GestionMedica.Mascota;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaHora;

    private String servicioId;
    private String servicioNombre;
    private Double precioAcordado;
    private String motivo;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    @ManyToOne
    @JoinColumn(name = "mascota_id",nullable = false)
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;

    public enum EstadoCita{
        PENDIENTE, CONFIRMADA, REALIZADA, CANCELADA
    }
}
