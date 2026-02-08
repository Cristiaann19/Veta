package com.example.vet.Service.GVentas;

import com.example.vet.Model.GestionVentas.Servicio;
import com.example.vet.Repository.GVentas.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> listarActivos() {
        return servicioRepository.findAll().stream()
                .filter(s -> s.getEstado().equals(Servicio.EstadoServicio.ACTIVO))
                .toList();
    }

    public List<Servicio> listar() {
        return servicioRepository.findAll();
    }

    public Servicio guardar(Servicio s) {
        return servicioRepository.save(s);
    }

    public Servicio actualizar(Long id, Servicio s) {
        Servicio existente = servicioRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(s.getNombre());
            existente.setDescripcion(s.getDescripcion());
            existente.setPrecio(s.getPrecio());
            existente.setEstado(s.getEstado());
            return servicioRepository.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        servicioRepository.deleteById(id);
    }
}