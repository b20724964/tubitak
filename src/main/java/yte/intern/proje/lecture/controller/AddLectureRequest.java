package yte.intern.proje.lecture.controller;

import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.lecture.entity.LectureType;
import yte.intern.proje.room.entity.RoomEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record AddLectureRequest(
        @NotEmpty
        @Size(max = 255)
        String name,

        @NotEmpty
        @Size(max = 255)
        String description,

        LectureType type,
        @NotEmpty
        String lectureCode

) {
    public Lecture toEntity() {
        return new Lecture(
                name,
                description,
                type,
                lectureCode
        );
    }
}
