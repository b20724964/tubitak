package yte.intern.proje.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.proje.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
