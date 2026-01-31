package com.example.vet.Service.GUsuarios;

import com.example.vet.Model.GestionUsuarios.Trabajador;
import com.example.vet.Repository.GUsuarios.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrabajadorService {
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<Trabajador> listarActivos() {
        return trabajadorRepository.findAll().stream()
                .filter(Trabajador::isActivo)
                .toList();
    }

    public Trabajador guardar(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }
}