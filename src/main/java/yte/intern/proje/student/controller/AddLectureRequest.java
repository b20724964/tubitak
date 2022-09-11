package yte.intern.proje.student.controller;

public record AddLectureRequest(
        Long studentId,
        Long lectureId
) {
}
