package com.example.vet.Model.Soporte;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoEvento;
    private String usuario;

    @Column(name = "fecha_hora",updatable = false)
    private LocalDateTime fechaHora;

    @PrePersist
    protected void onCreate(){
        this.fechaHora = LocalDateTime.now();
    }
    private String descripcion;

    @Column(columnDefinition = "JSON")
    private String detallesJson;
}
