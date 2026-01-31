package com.example.vet.Service.GUsuarios;

import com.example.vet.Model.GestionUsuarios.Cita;
import com.example.vet.Repository.GUsuarios.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> listarTodas() {
        return citaRepository.findAll();
    }

    public Cita guardar(Cita cita) {
        // Aquí podrías validar que el trabajador esté disponible en ese horario
        return citaRepository.save(cita);
    }

    public void cancelarCita(Long id) {
        Cita cita = citaRepository.findById(id).orElse(null);
        if (cita != null) {
            cita.setEstado(Cita.EstadoCita.CANCELADA);
            citaRepository.save(cita);
        }
    }
}