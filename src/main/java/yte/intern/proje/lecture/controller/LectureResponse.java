package yte.intern.proje.lecture.controller;

import yte.intern.proje.academician.controller.AcademicianResponse;
import yte.intern.proje.assistant.controller.AssistantResponse;
import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.lecture.entity.LectureType;
import yte.intern.proje.room.controller.RoomResponse;
import yte.intern.proje.room.entity.Room;
import yte.intern.proje.student.controller.StudentResponse;

import java.util.ArrayList;
import java.util.List;

public record LectureResponse(
        Long id,
        String name,
        String description,
        LectureType type,
        String lectureCode,
        RoomResponse room,
        List<StudentResponse> students,
        List<AssistantResponse> assistants,
        List<AcademicianResponse> academicians
) {
    public static LectureResponse fromEntity(Lecture lecture) {
        if(lecture.getRoom()==null){
            return new LectureResponse(
                    lecture.getId(),
                    lecture.getName(),
                    lecture.getDescription(),
                    lecture.getType(),
                    lecture.getLectureCode(),
                    new RoomResponse(
                            (long)0,
                            "",
                            true,
                            true,
                            true,
                            true,
                            (long)0,
                            new ArrayList<>()),
                    lecture.getStudents().stream()
                            .map(StudentResponse::fromEntity)
                            .toList(),
                    lecture.getAssistants().stream()
                            .map(AssistantResponse::fromEntity)
                            .toList(),
                    lecture.getAcademicians().stream()
                            .map(AcademicianResponse::fromEntity)
                            .toList()
            );
        }
        return new LectureResponse(
                lecture.getId(),
                lecture.getName(),
                lecture.getDescription(),
                lecture.getType(),
                lecture.getLectureCode(),
                new RoomResponse(
                        lecture.getRoom().getId(),
                        lecture.getRoom().getName(),
                        lecture.getRoom().isHasProjection(),
                        lecture.getRoom().isHasComputer(),
                        lecture.getRoom().isHasCooler(),
                        lecture.getRoom().isHasWindow(),
                        lecture.getRoom().getCapacity(),
                        lecture.getRoom().getTimetable()
                ),
                lecture.getStudents().stream()
                        .map(StudentResponse::fromEntity)
                        .toList(),
                lecture.getAssistants().stream()
                        .map(AssistantResponse::fromEntity)
                        .toList(),
                lecture.getAcademicians().stream()
                        .map(AcademicianResponse::fromEntity)
                        .toList()
        );
    }
}
