package yte.intern.proje.lecture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.proje.academician.service.AcademicianService;
import yte.intern.proje.assistant.service.AssistantService;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.common.response.ResultType;
import yte.intern.proje.lecture.controller.AddAcademicianRequest;
import yte.intern.proje.lecture.controller.AddAssistantRequest;
import yte.intern.proje.lecture.controller.AddStudentRequest;
import yte.intern.proje.lecture.controller.RemoveStudentRequest;
import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.lecture.repository.LectureRepository;
import yte.intern.proje.student.service.StudentService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final StudentService studentService;
    private final AcademicianService academicianService;
    private final AssistantService assistantService;

    public MessageResponse addLecture(Lecture lecture){
        lectureRepository.save(lecture);
        return  new MessageResponse("Lecture has been added successfully", ResultType.SUCCESS);
    }

    public List<Lecture> getAllLectures(){
        return lectureRepository.findAll();
    }

    public Lecture getLectureById(Long id){
        return lectureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lecture with ID %d not found".formatted(id)));
    }

    public MessageResponse updateLecture(Long id, Lecture newLecture) {
        Lecture existingLecture = getLectureById(id);
        existingLecture.update(newLecture);
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

    public MessageResponse removeStudent(RemoveStudentRequest request) {
        Lecture existingLecture = getLectureById(request.lectureId());
        existingLecture.removeStudent(studentService.getStudentById(request.studentId()));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Student removed to course with ID %d".formatted(request.lectureId()), ResultType.SUCCESS);
    }

    public MessageResponse addAcademician(AddAcademicianRequest request) {
        Lecture existingLecture = getLectureById(request.lectureId());
        existingLecture.addAcademician(academicianService.getAcademicianById(request.academicianId()));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Academician added to course with ID %d".formatted(request.lectureId()), ResultType.SUCCESS);
    }

    public MessageResponse addAssistant(AddAssistantRequest request) {
        Lecture existingLecture = getLectureById(request.lectureId());
        existingLecture.addAssistant(assistantService.getAssistantById(request.assistantId()));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Assistant added to course with ID %d".formatted(request.lectureId()), ResultType.SUCCESS);
    }
}

