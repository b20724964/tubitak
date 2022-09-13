package yte.intern.proje.academician.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yte.intern.proje.academician.service.AcademicianService;
import yte.intern.proje.common.response.MessageResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/academicians")
@RequiredArgsConstructor
public class AcademicianController {
    private final AcademicianService academicianService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public MessageResponse addAcademician(@RequestBody @Valid AddAcademicianRequest request){
        return academicianService.addAcademician(request.toEntity());
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<AcademicianResponse> getAllAcademicians(){
        return academicianService.getAllAcademician()
                .stream()
                .map(AcademicianResponse::fromEntity)
                .toList();
    }
    @PutMapping("/{id}")
    public MessageResponse updateStudent(@RequestBody @Valid UpdateAcademician request,
                                         @PathVariable Long id) {
        return academicianService.updateAcademician(id, request.toEntity());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteStudent(@PathVariable Long id) {
        return academicianService.deleteAcademician(id);
    }

}
