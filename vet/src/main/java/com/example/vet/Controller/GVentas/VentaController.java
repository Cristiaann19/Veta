package com.example.vet.Controller.GVentas;

import com.example.vet.Model.GestionVentas.Venta;
import com.example.vet.Service.GVentas.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<Venta> realizarVenta(@RequestBody Venta venta) {
        // Al guardar la venta, el cascade = CascadeType.ALL en el modelo
        // guardará automáticamente los objetos en DetalleVenta
        return ResponseEntity.ok(ventaService.realizarVenta(venta));
    }

    @GetMapping
    public List<Venta> listarTodas() {
        return ventaService.listarVentas();
    }
}