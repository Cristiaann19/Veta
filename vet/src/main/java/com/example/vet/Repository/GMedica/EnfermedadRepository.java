package com.example.vet.Repository.GMedica;

import com.example.vet.Model.GestionMedica.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermedadRepository extends JpaRepository<Enfermedad,Long> {
}
