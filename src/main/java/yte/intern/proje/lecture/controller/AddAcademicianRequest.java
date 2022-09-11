package yte.intern.proje.lecture.controller;

public record AddAcademicianRequest(
        Long lectureId,
        Long academicianId
) {
}
