package com.example.vet.Service.GMedica;

import com.example.vet.Model.GestionMedica.VacunaCatalogo;
import com.example.vet.Repository.GMedica.VacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VacunaService {

    @Autowired
    private VacunaRepository vacunaRepository;

    public List<VacunaCatalogo> listarTodas() {
        return vacunaRepository.findAll();
    }

    public VacunaCatalogo guardar(VacunaCatalogo vacuna) {
        return vacunaRepository.save(vacuna);
    }

    public VacunaCatalogo buscarPorId(Long id) {
        return vacunaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        vacunaRepository.deleteById(id);
    }

    public VacunaCatalogo actualizar(Long id, VacunaCatalogo vacuna) {
        VacunaCatalogo vacunaExistente = buscarPorId(id);
        if (vacunaExistente != null) {
            vacunaExistente.setNombre(vacuna.getNombre());
            vacunaExistente.setFabricante(vacuna.getFabricante());
            vacunaExistente.setPrecio(vacuna.getPrecio());
            vacunaExistente.setDosis(vacuna.getDosis());
            vacunaExistente.setEdadRecomendada(vacuna.getEdadRecomendada());
            vacunaExistente.setEnfermedadAsociada(vacuna.getEnfermedadAsociada());
            return guardar(vacunaExistente);
        }
        return null;
    }
}