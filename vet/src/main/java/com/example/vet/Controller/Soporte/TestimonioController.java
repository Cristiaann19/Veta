package com.example.vet.Controller.Soporte;

import com.example.vet.Model.Soporte.Testimonio;
import com.example.vet.Service.Soporte.TestimonioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/testimonios")
@CrossOrigin(origins = "*")
public class TestimonioController {

    @Autowired
    private TestimonioService testimonioService;

    @GetMapping
    public List<Testimonio> listar() {
        return testimonioService.listarRecientes();
    }

    @PostMapping
    public ResponseEntity<Testimonio> crear(@Valid @RequestBody Testimonio testimonio) {
        return ResponseEntity.ok(testimonioService.guardar(testimonio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        // Lógica para eliminar testimonio si fuera necesario
        return ResponseEntity.noContent().build();
    }
}