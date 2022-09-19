package yte.intern.proje.room.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.room.service.RoomService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public MessageResponse addRoom(@RequestBody @Valid AddRoomRequest request) {
        return roomService.addRoom(request.toEntity());
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('ADMIN','ACADAMICIAN')")
    public List<RoomResponse> getAllRooms() {
        return roomService.getAllRooms()
                .stream()
                .map(RoomResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public RoomResponse getRoomById(@PathVariable Long id) {
        return RoomResponse.fromEntity(roomService.getRoomById(id));
    }

    @PutMapping("/{id}")
    public MessageResponse updateRoom(@RequestBody @Valid UpdateRoomRequest request,
                                         @PathVariable Long id) {
        return roomService.updateRoom(id, request.toEntity());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteRoom(@PathVariable Long id) {
        return roomService.deleteRoom(id);
    }

}
