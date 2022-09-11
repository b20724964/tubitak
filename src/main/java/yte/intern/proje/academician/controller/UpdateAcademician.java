package yte.intern.proje.academician.controller;

import yte.intern.proje.academician.entity.Academician;
import yte.intern.proje.student.entity.Student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record UpdateAcademician(
        @NotEmpty
        @Size(max = 255)
        String name,
        @NotEmpty
        @Size(max = 255)
        String surname,
        @Email
        @Size(max = 255)
        String email

) {
    public Academician toEntity() {
        return new Academician(
                name,
                surname,
                email
        );
    }

}
