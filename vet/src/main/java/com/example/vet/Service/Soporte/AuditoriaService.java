package com.example.vet.Service.Soporte;

import com.example.vet.Model.Soporte.Auditoria;
import com.example.vet.Repository.Soporte.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaService {
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public List<Auditoria> listarTodas(){
        return auditoriaRepository.findAll();
    }

    public void registrarEvento(Auditoria auditoria) {
        auditoriaRepository.save(auditoria);
    }


}