package yte.intern.proje.lecture.controller;

import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.lecture.entity.LectureType;
import yte.intern.proje.lecture.entity.Room;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record UpdateLectureRequest(
        @NotEmpty
        @Size(max = 255)
        String name,

        @NotEmpty
        @Size(max = 255)
        String description,

        @NotEmpty
        LectureType type,

        @NotEmpty
        String lectureCode,

        @NotEmpty
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
