package yte.intern.proje.lecture.controller;

import javax.validation.constraints.NotEmpty;

public record AddStudentWithStudentNumberRequest(
        @NotEmpty
        Long lectureId,
        @NotEmpty
        String studentNumber
) {
}
