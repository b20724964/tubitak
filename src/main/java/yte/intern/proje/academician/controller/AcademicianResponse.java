package yte.intern.proje.academician.controller;

import yte.intern.proje.academician.entity.Academician;
import yte.intern.proje.student.controller.StudentResponse;
import yte.intern.proje.student.entity.Student;

public record AcademicianResponse(
        Long id,
        String name,
        String surname,
        String email
) {
    public static AcademicianResponse fromEntity(Academician academician) {
        return new AcademicianResponse(
                academician.getId(),
                academician.getName(),
                academician.getSurname(),
                academician.getEmail()
        );
    }
}
