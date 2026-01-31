package com.example.vet.Model.GestionUsuarios;

import com.example.vet.Model.GestionMedica.Mascota;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String dni;

    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;

    @Column(unique = true)
    private String correo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Mascota> mascota = new ArrayList<>();

}
