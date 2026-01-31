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
}