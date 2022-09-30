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
    public MessageResponse addLecture(@RequestBody @Valid AddLectureRequest request) {
        return lectureService.addLecture(request.toEntity());
    }

    @GetMapping
   // @PreAuthorize("hasAnyAuthority('ADMIN','ACADAMICIAN')")
    public List<LectureResponse> getAllLectures() {
        return lectureService.getAllLectures()
                .stream()
                .map(LectureResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public LectureResponse getLectureById(@PathVariable Long id) {
        return LectureResponse.fromEntity(lectureService.getLectureById(id));
    }

    @GetMapping("/student/{username}")
    public List<LectureResponse> getStudentLectures(@PathVariable String username) {
        return lectureService.getStudentLectures(username)
                .stream()
                .map(LectureResponse::fromEntity)
                .toList();
    }

    @PutMapping("/quick/{id}")
    public MessageResponse quickUpdateLecture(@RequestBody @Valid QuickUpdateLectureRequest request,
                                              @PathVariable Long id) {
        return lectureService.quickUpdateLecture(id, request.toEntity());
    }
    @PutMapping("/{id}")
    public MessageResponse updateLecture(@RequestBody @Valid UpdateLectureRequest request,
                                              @PathVariable Long id) {
        return lectureService.updateLecture(id, request);
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
    @PostMapping("/addstudentwithstudentnumber/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addStudentWithStudentNumber(@RequestBody String studentNumber, @PathVariable Long id) {
        return lectureService.addStudentWithStudentNumber(id, studentNumber.substring(0,studentNumber.length() - 1));
    }

    @PostMapping("/removestudent/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse removeStudent(@RequestBody String studentId, @PathVariable Long id) {
        return lectureService.removeStudent(id,Long.parseLong(studentId.substring(0,studentId.length() - 1)));
    }

    @PostMapping("/addacademician")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addAcademician(@RequestBody AddAcademicianRequest addAcademicianRequest) {
        return lectureService.addAcademician(addAcademicianRequest);
    }

    @PostMapping("/removeacademician/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse removeAcademician(@RequestBody String academicianId, @PathVariable Long id) {
        return lectureService.removeAcademician(id,Long.parseLong(academicianId.substring(0,academicianId.length() - 1)));
    }

    @PostMapping("/addassistant")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse addAssistant(@RequestBody AddAssistantRequest addAssistantRequest) {
        return lectureService.addAssistant(addAssistantRequest);
    }

    @PostMapping("/removeassistant/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse removeAssistant(@RequestBody String assistantId, @PathVariable Long id) {
        return lectureService.removeAssistant(id,Long.parseLong(assistantId.substring(0,assistantId.length() - 1)));
    }
}
