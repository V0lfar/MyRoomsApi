package my.rooms.vif.controller;

import my.rooms.vif.model.Room;
import my.rooms.vif.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<Room> getAllRooms()
    {
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{code}")
    public Room getRoom(@PathVariable(required = true) String code)
    {
        return roomService.getRoomByCode(code);
    }

    @GetMapping("/rooms/{code}/exist")
    public Boolean isRoomExist(@PathVariable(required = true) String code)
    {
        return nonNull(roomService.getRoomByCode(code));
    }
}
