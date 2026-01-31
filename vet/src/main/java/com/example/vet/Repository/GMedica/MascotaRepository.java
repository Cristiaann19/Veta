package com.example.vet.Repository.GMedica;

import com.example.vet.Model.GestionMedica.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {
}
