package yte.intern.proje.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.student.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addStudent(@RequestBody @Valid AddStudentRequest request) {
        return studentService.addStudent(request.toEntity());
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(StudentResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return StudentResponse.fromEntity(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public MessageResponse updateStudent(@RequestBody @Valid UpdateStudentRequest request,
                                         @PathVariable Long id) {
        return studentService.updateStudent(id, request.toEntity());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

   // @PostMapping("/addlecture")
   // //@PreAuthorize("hasAuthority('ADMIN')")
   // public MessageResponse addLesson(@RequestBody AddLectureRequest addLectureRequest) {
   //     return studentService.addLesson(addLectureRequest);
   // }
//
}
