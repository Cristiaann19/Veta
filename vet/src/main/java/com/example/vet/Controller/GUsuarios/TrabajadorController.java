package com.example.vet.Controller.GUsuarios;

import com.example.vet.Model.GestionUsuarios.Trabajador;
import com.example.vet.Service.GUsuarios.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
@CrossOrigin(origins = "*")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public List<Trabajador> listarActivos() {
        return trabajadorService.listarActivos();
    }

    @PostMapping
    public Trabajador guardar(@RequestBody Trabajador trabajador) {
        return trabajadorService.guardar(trabajador);
    }
}