package com.example.vet.Service.GMedica;

import com.example.vet.Model.GestionMedica.Mascota;
import com.example.vet.Repository.GMedica.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> listarTodas(){
        return  mascotaRepository.findAll();
    }

    public Mascota guardar(Mascota mascota){
        return mascotaRepository.save(mascota);
    }

    public Mascota buscarPorId(Long id){
        return mascotaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        mascotaRepository.deleteById(id);
    }
}
