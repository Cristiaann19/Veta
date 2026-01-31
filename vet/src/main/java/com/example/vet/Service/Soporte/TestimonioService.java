package com.example.vet.Service.Soporte;

import com.example.vet.Model.Soporte.Testimonio;
import com.example.vet.Repository.Soporte.TestimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestimonioService {
    @Autowired
    private TestimonioRepository testimonioRepository;

    public List<Testimonio> listarRecientes() {
        return testimonioRepository.findAll();
    }

    public Testimonio guardar(Testimonio t) {
        return testimonioRepository.save(t);
    }
}