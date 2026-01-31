package com.example.vet.Repository.Soporte;

import com.example.vet.Model.Soporte.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria,Long> {
}
