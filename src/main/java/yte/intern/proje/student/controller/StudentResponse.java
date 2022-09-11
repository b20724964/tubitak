package yte.intern.proje.student.controller;

import yte.intern.proje.student.entity.Student;

public record StudentResponse(
        Long id,
        String name,
        String surname,
        String email,
        String studentNumber
) {
    public static StudentResponse fromEntity(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getEmail(),
                student.getStudentNumber()
        );
    }
}
