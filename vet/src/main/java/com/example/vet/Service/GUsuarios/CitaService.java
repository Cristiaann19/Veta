package com.example.vet.Service.GUsuarios;
import com.example.vet.DTO.CitaDTO;
import com.example.vet.Model.GestionUsuarios.Cita;
import com.example.vet.Repository.GUsuarios.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<CitaDTO> listarCitas() {
        return citaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private CitaDTO toDTO(Cita cita) {
        CitaDTO dto = new CitaDTO();
        dto.setId(cita.getId());
        dto.setFechaHora(cita.getFechaHora());
        dto.setServicioNombre(cita.getServicioNombre());
        dto.setPrecioAcordado(cita.getPrecioAcordado());
        dto.setMotivo(cita.getMotivo());
        dto.setEstado(cita.getEstado().name());

        // Datos de la mascota
        if (cita.getMascota() != null) {
            dto.setMascotaId(cita.getMascota().getId());
            dto.setMascotaNombre(cita.getMascota().getNombre());

            // Datos del cliente (dueño de la mascota)
            if (cita.getMascota().getCliente() != null) {
                dto.setClienteId(cita.getMascota().getCliente().getId());
                dto.setClienteNombre(
                        cita.getMascota().getCliente().getNombres() + " " +
                                cita.getMascota().getCliente().getApellidos()
                );
            }
        }

        // Datos del trabajador
        if (cita.getTrabajador() != null) {
            dto.setTrabajadorId(cita.getTrabajador().getId());
            dto.setTrabajadorNombre(
                    cita.getTrabajador().getNombres() + " " +
                            cita.getTrabajador().getApellidos()
            );
        }

        return dto;
    }
}
