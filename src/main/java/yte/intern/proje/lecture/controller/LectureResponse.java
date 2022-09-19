package yte.intern.proje.lecture.controller;

import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.lecture.entity.LectureType;
import yte.intern.proje.room.entity.Room;
import yte.intern.proje.room.entity.RoomEnum;

public record LectureResponse(
        Long id,
        String name,
        String description,
        LectureType type,
        String lectureCode,
        Room room
) {
    public static LectureResponse fromEntity(Lecture lecture) {
        return new LectureResponse(
                lecture.getId(),
                lecture.getName(),
                lecture.getDescription(),
                lecture.getType(),
                lecture.getLectureCode(),
                lecture.getRoom()
        );
    }
}
