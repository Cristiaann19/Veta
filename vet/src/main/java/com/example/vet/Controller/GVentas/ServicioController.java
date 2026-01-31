package com.example.vet.Controller.GVentas;

import com.example.vet.Model.GestionVentas.Servicio;
import com.example.vet.Service.GVentas.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/activos")
    public List<Servicio> listarActivos() {
        return servicioService.listarActivos();
    }

    @PostMapping
    public Servicio guardar(@RequestBody Servicio servicio) {
        return servicioService.guardar(servicio);
    }
}