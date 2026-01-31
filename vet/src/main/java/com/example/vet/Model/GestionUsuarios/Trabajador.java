package com.example.vet.Model.GestionUsuarios;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="trabajadores")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String dni;
    private String nombres;
    private String apellidos;

    @Enumerated(EnumType.STRING)
    private cargoTrabajador cargo;
    private String telefono;
    private String correo;
    private boolean activo = true;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("usuario")
    private Usuario usuario;

    public enum cargoTrabajador{
        VETERINARIO, ESTILISTA, CIRUJANO, RECEPCIONISTA, ADMINISTRADOR
    }
}

