package yte.intern.proje.lecture.controller;

public record AddAssistantRequest(
        Long lectureId,
        Long assistantId
) {
}
