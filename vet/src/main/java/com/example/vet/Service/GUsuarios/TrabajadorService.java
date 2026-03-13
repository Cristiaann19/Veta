package com.example.vet.Service.GUsuarios;

import com.example.vet.Model.GestionUsuarios.Trabajador;
import com.example.vet.Repository.GUsuarios.TrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrabajadorService {

    private static final Logger logger = LoggerFactory.getLogger(TrabajadorService.class);

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<Trabajador> listarActivos() {
        logger.info("TRABAJADORES ACTIVOS LISTADOS");
        return trabajadorRepository.findAll().stream()
                .filter(trabajador -> trabajador.getEstado() == Trabajador.estadoTrabajador.ACTIVO)
                .toList();
    }

    public List<Trabajador> listarTodos() {
        logger.info("TRABAJADORES LISTADOS - TODOS");
        return trabajadorRepository.findAll();
    }

    public Trabajador guardar(Trabajador trabajador) {
        logger.info("TRABAJADOR GUARDADO CORRECTAMENTE");
        return trabajadorRepository.save(trabajador);
    }

    public void eliminar(Long id){
        logger.info("TRABAJADOR ELIMINADO:" + id);
        trabajadorRepository.deleteById(id);
    }

    //ACTUALIZAR


}