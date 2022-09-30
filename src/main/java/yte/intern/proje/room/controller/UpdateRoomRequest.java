package yte.intern.proje.room.controller;

import yte.intern.proje.room.entity.Room;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public record UpdateRoomRequest(
        @NotEmpty
        @Size(max = 255)
        String name,
        boolean hasProjection,
        boolean hasComputer,
        boolean hasCooler,
        boolean hasWindow,

        @Min(value=15, message="must be equal or greater than 15")
        @Max(value=100, message="must be equal or less than 100")
        Long capacity


) {
    public Room toEntity(){
        return new Room(
                name,
                hasProjection,
                hasComputer,
                hasCooler,
                hasWindow,
                capacity
        );
    }

}
