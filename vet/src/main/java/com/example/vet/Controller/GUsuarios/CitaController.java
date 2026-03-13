package com.example.vet.Controller.GUsuarios;

import com.example.vet.DTO.CitaDTO;
import com.example.vet.DTO.CitaRequestDTO;
import com.example.vet.DTO.DashboardDTO;
import com.example.vet.Model.GestionUsuarios.Cita;
import com.example.vet.Service.GUsuarios.CitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// CitaController.java
@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<CitaDTO>> listarCitas() {
        return ResponseEntity.ok(citaService.listarCitas());
    }

    @PostMapping
    public ResponseEntity<CitaDTO> crearCita(@RequestBody @Valid CitaRequestDTO request) {
        return ResponseEntity.ok(citaService.crearCita(request));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardDTO> getDashboard(){
        return ResponseEntity.ok(citaService.getDashboard());
    }
}