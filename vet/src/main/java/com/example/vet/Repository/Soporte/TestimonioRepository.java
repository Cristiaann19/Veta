package com.example.vet.Repository.Soporte;

import com.example.vet.Model.Soporte.Testimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonioRepository extends JpaRepository<Testimonio,Long> {
}
