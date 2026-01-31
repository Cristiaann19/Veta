package com.example.vet.Service.GMedica;

import com.example.vet.Model.GestionMedica.Enfermedad;
import com.example.vet.Repository.GMedica.EnfermedadRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfermedadService {

    @Autowired
    private EnfermedadRepository enfermedadRepository;

    public List<Enfermedad> listarTodas(){
        return enfermedadRepository.findAll();
    }

    public Enfermedad guardar (Enfermedad enfermedad){
        return enfermedadRepository.save(enfermedad);
    }

    public Enfermedad buscarPorId(Long id) {
        return enfermedadRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        enfermedadRepository.deleteById(id);
    }
}
