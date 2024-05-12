package my.rooms.vif.service;

import my.rooms.vif.model.Room;
import my.rooms.vif.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomByCode(String code) {
        return roomRepository.findByCode(code);
    }
}
