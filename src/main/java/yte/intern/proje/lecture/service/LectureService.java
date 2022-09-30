package yte.intern.proje.lecture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.proje.academician.service.AcademicianService;
import yte.intern.proje.assistant.service.AssistantService;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.common.response.ResultType;
import yte.intern.proje.lecture.controller.*;
import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.lecture.repository.LectureRepository;
import yte.intern.proje.room.entity.Room;
import yte.intern.proje.room.service.RoomService;
import yte.intern.proje.student.entity.Student;
import yte.intern.proje.student.service.StudentService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final StudentService studentService;
    private final AcademicianService academicianService;
    private final AssistantService assistantService;

    private final RoomService roomService;

    public MessageResponse addLecture(Lecture lecture){
        lectureRepository.save(lecture);
        return  new MessageResponse("Lecture has been added successfully", ResultType.SUCCESS);
    }

    public List<Lecture> getAllLectures(){
        List<Lecture> lectures=lectureRepository.findAll();
        return lectures;
    }


    public Lecture getLectureById(Long id){
        return lectureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lecture with ID %d not found".formatted(id)));
    }

    public List<Lecture> getStudentLectures(String userName){
        List<Lecture> lectures= new ArrayList<>();
        Set<Lecture> setLectures= studentService.getStudentByStudentNumber(userName).getLectures();
        lectures.addAll(setLectures);
        return lectures;
    }

    public MessageResponse quickUpdateLecture(Long id, Lecture newLecture) {
        Lecture existingLecture = getLectureById(id);
        existingLecture.update(newLecture);
        lectureRepository.save(existingLecture);
        return new MessageResponse("Lecture with id %d has been updated".formatted(id), ResultType.SUCCESS);
    }
    public MessageResponse updateLecture(Long id, UpdateLectureRequest request) {
        Lecture existingLecture = getLectureById(id);
        if(request.studentIds()!=null){
        for (Long studentId:request.studentIds()) {
            addStudent(new AddStudentRequest(id,studentId));
        }}

        Room existingRoom= roomService.getRoomById(request.roomId());
        existingLecture.updateRoom(existingRoom);
        lectureRepository.save(existingLecture);
        return new MessageResponse("Lecture with id %d has been updated".formatted(id), ResultType.SUCCESS);
    }

    public MessageResponse deleteLecture(Long id) {
        Lecture existingLecture = getLectureById(id);
        existingLecture.clearLecture();
        lectureRepository.save(existingLecture);
        lectureRepository.delete(existingLecture);
        return new MessageResponse("Lecture with id %d has been deleted", ResultType.SUCCESS);
    }

    public MessageResponse addStudent(AddStudentRequest request) {
        Lecture existingLecture = getLectureById(request.lectureId());
        existingLecture.addStudent(studentService.getStudentById(request.studentId()));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Student added to course with ID %d".formatted(request.lectureId()), ResultType.SUCCESS);
    }

    public MessageResponse addStudentWithStudentNumber(Long lectureId, String studentNumber) {
        Lecture existingLecture = getLectureById(lectureId);
        existingLecture.addStudent(studentService.getStudentByStudentNumber(studentNumber));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Student added to course with ID %d".formatted(lectureId), ResultType.SUCCESS);
    }

    public MessageResponse removeStudent(Long id, Long studentId) {
        Lecture existingLecture = getLectureById(id);
        existingLecture.removeStudent(studentService.getStudentById(studentId));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Student removed to course with ID %d".formatted(id), ResultType.SUCCESS);
    }

    public MessageResponse addAcademician(AddAcademicianRequest request) {
        Lecture existingLecture = getLectureById(request.lectureId());
        existingLecture.addAcademician(academicianService.getAcademicianById(request.academicianId()));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Academician added to course with ID %d".formatted(request.lectureId()), ResultType.SUCCESS);
    }

    public MessageResponse removeAcademician(Long id, Long academicianId) {
        Lecture existingLecture = getLectureById(id);
        existingLecture.removeAcademician(academicianService.getAcademicianById(academicianId));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Student removed to course with ID %d".formatted(id), ResultType.SUCCESS);
    }

    public MessageResponse addAssistant(AddAssistantRequest request) {
        Lecture existingLecture = getLectureById(request.lectureId());
        existingLecture.addAssistant(assistantService.getAssistantById(request.assistantId()));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Assistant added to course with ID %d".formatted(request.lectureId()), ResultType.SUCCESS);
    }
    public MessageResponse removeAssistant(Long id, Long assistantId) {
        Lecture existingLecture = getLectureById(id);
        existingLecture.removeAssistant(assistantService.getAssistantById(assistantId));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Student removed to course with ID %d".formatted(id), ResultType.SUCCESS);
    }
}

