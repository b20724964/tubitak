package yte.intern.proje.academician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.proje.academician.entity.Academician;

public interface AcademicianRepository extends JpaRepository<Academician, Long> {
}
