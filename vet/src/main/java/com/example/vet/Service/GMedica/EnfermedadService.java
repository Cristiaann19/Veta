package com.example.vet.Service.GMedica;

import com.example.vet.Model.GestionMedica.Enfermedad;
import com.example.vet.Repository.GMedica.EnfermedadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfermedadService {

    private static final Logger logger = LoggerFactory.getLogger(EnfermedadService.class);

    @Autowired
    private EnfermedadRepository enfermedadRepository;

    public List<Enfermedad> listarTodas(){
        logger.info("Listado de las enfermedades");
        return enfermedadRepository.findAll();
    }

    public Enfermedad guardar (Enfermedad enfermedad){
        logger.info("Nueva enfermedad registrada", enfermedad);
        return enfermedadRepository.save(enfermedad);
    }

    public Enfermedad buscarPorId(Long id) {
        logger.info("Busqueda por id");
        return enfermedadRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        logger.info("Enfermedad guardada en el sistema", id);
        enfermedadRepository.deleteById(id);
    }
}
