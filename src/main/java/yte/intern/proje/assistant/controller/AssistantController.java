package yte.intern.proje.assistant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yte.intern.proje.academician.controller.AcademicianResponse;
import yte.intern.proje.academician.controller.AddAcademicianRequest;
import yte.intern.proje.academician.controller.UpdateAcademician;
import yte.intern.proje.academician.service.AcademicianService;
import yte.intern.proje.assistant.service.AssistantService;
import yte.intern.proje.common.response.MessageResponse;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/assistants")
@RequiredArgsConstructor
public class AssistantController {
    private final AssistantService assistantService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public MessageResponse addAssistant(@RequestBody @Valid AddAssistantRequest request){
        return assistantService.addAssistant(request.toEntity());
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<AssistantResponse> getAllAssistants(){
        return assistantService.getAllAssistants()
                .stream()
                .map(AssistantResponse::fromEntity)
                .toList();
    }
    @PutMapping("/{id}")
    public MessageResponse updateAssistant(@RequestBody @Valid UpdateAssistant request,
                                         @PathVariable Long id) {
        return assistantService.updateAssistant(id, request.toEntity());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteAssistant(@PathVariable Long id) {
        return assistantService.deleteAssistant(id);
    }

}
