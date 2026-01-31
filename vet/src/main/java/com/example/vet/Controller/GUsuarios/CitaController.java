package com.example.vet.Controller.GUsuarios;

import com.example.vet.Model.GestionUsuarios.Cita;
import com.example.vet.Service.GUsuarios.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> listar() {
        return citaService.listarTodas();
    }

    @PostMapping
    public Cita programar(@RequestBody Cita cita) {
        return citaService.guardar(cita);
    }

    @PutMapping("/{id}/cancelar")
    public void cancelar(@PathVariable Long id) {
        citaService.cancelarCita(id);
    }
}