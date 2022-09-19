package yte.intern.proje.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.proje.room.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
