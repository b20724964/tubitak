package yte.intern.proje.lecture.controller;

import javax.validation.constraints.NotEmpty;

public record RemoveStudentRequest(
        @NotEmpty
        Long lectureId,
        @NotEmpty
        Long studentId
) {
}
