package yte.intern.proje.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.common.response.ResultType;
import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.lecture.repository.LectureRepository;
import yte.intern.proje.lecture.service.LectureService;
import yte.intern.proje.login.entity.Authority;
import yte.intern.proje.login.entity.CustomUser;
import yte.intern.proje.login.repository.UserRepository;
import yte.intern.proje.student.controller.AddLectureRequest;
import yte.intern.proje.student.entity.Student;
import yte.intern.proje.student.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public MessageResponse addStudent(Student student) {

        Random random = new Random();
        int randomPassword = random.nextInt(10000000);

        studentRepository.save(student);
        userRepository.save(new CustomUser(null, student.getStudentNumber(), passwordEncoder.encode(Integer.toString(randomPassword)), List.of(new Authority("STUDENT"))));

        return new MessageResponse("Student has been added successfully\n"+"Password: "+randomPassword, ResultType.SUCCESS);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID %d not found".formatted(id)));
    }

    public MessageResponse updateStudent(Long id, Student newStudent) {
        Student existingStudent = getStudentById(id);
        existingStudent.update(newStudent);
        studentRepository.save(existingStudent);
        return new MessageResponse("Student with id %d has been updated".formatted(id), ResultType.SUCCESS);
    }

    public MessageResponse deleteStudent(Long id) {
        Student existingStudent = getStudentById(id);
        existingStudent.clearStudent();
        studentRepository.save(existingStudent);
        studentRepository.deleteById(id);

        return new MessageResponse("Student with id %d has been deleted", ResultType.SUCCESS);
    }

}
