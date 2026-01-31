package com.example.vet.Controller.GMedica;

import com.example.vet.Model.GestionMedica.Enfermedad;
import com.example.vet.Service.GMedica.EnfermedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enfermedades")
@CrossOrigin(origins = "*") // Importante para la Unidad 3 con Angular
public class EnfermedadController {

    @Autowired
    private EnfermedadService enfermedadService;

    @GetMapping
    public List<Enfermedad> listar() {
        return enfermedadService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<Enfermedad> crear(@RequestBody Enfermedad enfermedad) {
        return ResponseEntity.ok(enfermedadService.guardar(enfermedad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enfermedad> obtenerPorId(@PathVariable Long id) {
        Enfermedad enfermedad = enfermedadService.buscarPorId(id);
        return enfermedad != null ? ResponseEntity.ok(enfermedad) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        enfermedadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}