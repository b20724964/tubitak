package yte.intern.proje.lecture.controller;

import javax.validation.constraints.NotEmpty;

public record AddStudentRequest(
        @NotEmpty
        Long lectureId,
        @NotEmpty
        Long studentId

) {
}
