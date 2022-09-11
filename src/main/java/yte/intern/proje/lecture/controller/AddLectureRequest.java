package yte.intern.proje.lecture.controller;

import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.lecture.entity.LectureType;
import yte.intern.proje.lecture.entity.Room;
import yte.intern.proje.student.entity.Student;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public record AddLectureRequest(
        @NotEmpty
        @Size(max = 255)
        String name,

        @NotEmpty
        @Size(max = 255)
        String description,

        LectureType type,
        @NotEmpty
        String lectureCode,

        Room room
) {
    public Lecture toEntity() {
        return new Lecture(
                name,
                description,
                type,
                lectureCode,
                room
        );
    }
}
