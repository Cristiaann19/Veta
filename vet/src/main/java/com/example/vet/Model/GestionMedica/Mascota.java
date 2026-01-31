package com.example.vet.Model.GestionMedica;

import com.example.vet.Model.GestionUsuarios.Cita;
import com.example.vet.Model.GestionUsuarios.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private String edad;
    private double peso;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonIgnoreProperties("mascotas")
    @ToString.Exclude
    private Cliente cliente;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HistorialClinico> historialesClinicos;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cita> citas;
}
