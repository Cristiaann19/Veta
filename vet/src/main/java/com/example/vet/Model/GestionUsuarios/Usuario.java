package com.example.vet.Model.GestionUsuarios;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;

    @OneToOne
    @JoinColumn(name = "trabajador_id")
    private Trabajador trabajador;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private estadoUsuario estado;

    public enum estadoUsuario {
        ACTIVO, INACTIVO
    }
}
