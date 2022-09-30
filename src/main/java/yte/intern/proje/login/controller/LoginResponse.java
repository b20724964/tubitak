package yte.intern.proje.login.controller;

import yte.intern.proje.login.entity.CustomUser;
import yte.intern.proje.student.controller.StudentResponse;
import yte.intern.proje.student.entity.Student;

public record LoginResponse(
        String username,
        String authority
) {
    public static LoginResponse fromEntity(CustomUser user) {
        return new LoginResponse(
                user.getUsername(),
                user.getAuthorities().get(0).getAuthority()
        );
    }
}
