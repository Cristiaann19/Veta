package com.example.vet.Model.Soporte;

import com.example.vet.Model.GestionUsuarios.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table (name = "testimonios")
public class Testimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    @NotNull(message = "La calificación es obligatoria")
    @Min(value = 1, message = "La calificación minima es 1 estrella")
    @Max(value = 1, message = "La calificación máxima es 4 estrella")
    private Integer estrellas;

    private LocalDate fecha;

    @PrePersist
    protected void onCreate() {
        this.fecha = LocalDate.now();
    }
    private String avatarUrl;

}
