package yte.intern.proje.lecture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.proje.academician.service.AcademicianService;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.common.response.ResultType;
import yte.intern.proje.lecture.controller.AddAcademicianRequest;
import yte.intern.proje.lecture.controller.AddStudentRequest;
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
        lectureRepository.deleteById(id);
        return new MessageResponse("Lecture with id %d has been deleted", ResultType.SUCCESS);
    }

    public MessageResponse addStudent(AddStudentRequest addStudentRequest) {
        Lecture existingLecture = getLectureById(addStudentRequest.lectureId());
        existingLecture.addStudent(studentService.getStudentById(addStudentRequest.studentId()));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Student added to course with ID %d".formatted(addStudentRequest.lectureId()), ResultType.SUCCESS);
    }

    public MessageResponse addAcademician(AddAcademicianRequest addAcademicianRequest) {
        Lecture existingLecture = getLectureById(addAcademicianRequest.lectureId());
        existingLecture.addAcademician(academicianService.getAcademicianById(addAcademicianRequest.academicianId()));
        lectureRepository.save(existingLecture);
        return new MessageResponse("Academician added to course with ID %d".formatted(addAcademicianRequest.lectureId()), ResultType.SUCCESS);

    }
}

