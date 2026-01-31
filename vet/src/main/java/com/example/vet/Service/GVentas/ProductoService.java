package com.example.vet.Service.GVentas;

import com.example.vet.Model.GestionVentas.Producto;
import com.example.vet.Repository.GVentas.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listar() { return productoRepository.findAll(); }

    public Producto guardar(Producto p) { return productoRepository.save(p); }

    public void actualizarStock(Long id, Integer cantidad) {
        Producto p = productoRepository.findById(id).orElse(null);
        if(p != null) {
            p.setStock(p.getStock() - cantidad);
            productoRepository.save(p);
        }
    }
}