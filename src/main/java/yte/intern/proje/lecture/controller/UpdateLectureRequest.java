package yte.intern.proje.lecture.controller;

import yte.intern.proje.academician.entity.Academician;
import yte.intern.proje.assistant.entity.Assistant;
import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.lecture.entity.LectureType;
import yte.intern.proje.room.entity.Room;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public record UpdateLectureRequest(
        @NotEmpty
        String name,
        @NotEmpty
        String description,
        LectureType type,
        @NotEmpty
        String lectureCode,
        Long roomId,
        List<Long> academicianIds,
        List<Long> assistantIds,
        List<Long> studentIds

) {

}
