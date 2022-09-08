package yte.intern.proje.common.response;

public record MessageResponse(
        String message,
        ResultType resultType
) {
}
