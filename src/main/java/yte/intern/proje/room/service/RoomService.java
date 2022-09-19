package yte.intern.proje.room.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.common.response.ResultType;
import yte.intern.proje.lecture.entity.Lecture;
import yte.intern.proje.room.entity.Room;
import yte.intern.proje.room.repository.RoomRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public MessageResponse addRoom(Room room){
        roomRepository.save(room);
        return new MessageResponse("Room has been added successfully", ResultType.SUCCESS);
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    public Room getRoomById(Long id){
        return roomRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Room with ID %d not found".formatted(id)));
    }
    public MessageResponse updateRoom(Long id, Room newRoom) {
        Room existingRoom = getRoomById(id);
        existingRoom.update(newRoom);
        roomRepository.save(existingRoom);
        return new MessageResponse("Room with id %d has been updated".formatted(id), ResultType.SUCCESS);
    }

    public MessageResponse deleteRoom(Long id) {
        roomRepository.deleteById(id);
        return new MessageResponse("Room with id %d has been deleted", ResultType.SUCCESS);
    }

}

