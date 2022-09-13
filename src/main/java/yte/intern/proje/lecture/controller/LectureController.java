package yte.intern.proje.lecture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.lecture.service.LectureService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lectures")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','ACADAMICIAN')")
    public MessageResponse addStudent(@RequestBody @Valid AddLectureRequest request) {
        return lectureService.addLecture(request.toEntity());
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','ACADAMICIAN')")
    public List<LectureResponse> getAllLectures() {
        return lectureService.getAllLectures()
                .stream()
                .map(LectureResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public LectureResponse getStudentById(@PathVariable Long id) {
        return LectureResponse.fromEntity(lectureService.getLectureById(id));
    }

    @PutMapping("/{id}")
    public MessageResponse updateLecture(@RequestBody @Valid UpdateLectureRequest request,
                                         @PathVariable Long id) {
        return lectureService.updateLecture(id, request.toEntity());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteLecture(@PathVariable Long id) {
        return lectureService.deleteLecture(id);
    }

    @PostMapping("/addstudent")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addStudent(@RequestBody AddStudentRequest addStudentRequest) {
        return lectureService.addStudent(addStudentRequest);
    }

    @PostMapping("/addacademician")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addAcademician(@RequestBody AddAcademicianRequest addAcademicianRequest) {
        return lectureService.addAcademician(addAcademicianRequest);
    }
}
