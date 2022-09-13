package yte.intern.proje.assistant.controller;

import yte.intern.proje.academician.entity.Academician;
import yte.intern.proje.assistant.entity.Assistant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record AddAssistantRequest(
        @NotEmpty
        @Size(max=255)
        String name,

        @NotEmpty
        @Size(max=255)
        String surname,

        @Email
        @Size(max = 255)
        String email
) {
    public Assistant toEntity() {
        return new Assistant(
                name,
                surname,
                email
        );
    }
}
