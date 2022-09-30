package yte.intern.proje.room.controller;

import yte.intern.proje.room.entity.Room;
import java.util.List;

public record RoomResponse(
        Long id,
        String name,
        boolean hasProjection,
        boolean hasComputer,
        boolean hasCooler,
        boolean hasWindow,
        Long capacity,
        List<String> timeTable
) {
    public static RoomResponse fromEntity(Room room){
        return new RoomResponse(
                room.getId(),
                room.getName(),
                room.isHasProjection(),
                room.isHasComputer(),
                room.isHasCooler(),
                room.isHasWindow(),
                room.getCapacity(),
                room.getTimetable()
        );
    }
}
