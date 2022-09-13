package yte.intern.proje.assistant.controller;

import yte.intern.proje.academician.controller.AcademicianResponse;
import yte.intern.proje.academician.entity.Academician;
import yte.intern.proje.assistant.entity.Assistant;

public record AssistantResponse(
        Long id,
        String name,
        String surname,
        String email
) {
    public static AssistantResponse fromEntity(Assistant assistant) {
        return new AssistantResponse(
                assistant.getId(),
                assistant.getName(),
                assistant.getSurname(),
                assistant.getEmail()
        );
    }
}
