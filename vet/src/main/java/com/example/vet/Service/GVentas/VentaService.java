package com.example.vet.Service.GVentas;

import com.example.vet.Model.GestionVentas.Venta;
import com.example.vet.Repository.GVentas.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public Venta realizarVenta(Venta venta) {
        // Aquí podrías añadir lógica para calcular el total antes de guardar
        return ventaRepository.save(venta);
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }
}