package com.example.vet.Controller.Soporte;

import com.example.vet.Model.Soporte.Auditoria;
import com.example.vet.Service.Soporte.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
@CrossOrigin(origins = "*")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping
    public List<Auditoria> obtenerRegistros() {
        return auditoriaService.listarTodas();
    }

    @PostMapping
    public void registrar(@RequestBody Auditoria auditoria) {
        auditoriaService.registrarEvento(auditoria);
    }
}