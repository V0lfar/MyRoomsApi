package my.rooms.vif.controller;

import my.rooms.vif.model.Room;
import my.rooms.vif.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;
import static org.hibernate.internal.util.StringHelper.isBlank;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getRooms(@RequestParam(defaultValue = "") String term,
                                               @RequestParam(defaultValue = "name-asc") String sort) {
        return isBlank(term) ? ResponseEntity.ok(roomService.getAllRooms(sort)) : ResponseEntity.ok(roomService.searchRoomByTerm(term, sort));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/rooms/{code}")
    public ResponseEntity<Room> getRoom(@PathVariable(required = true) String code) {
        final Room room = roomService.getRoomByCode(code);
        return isNull(room) ? ResponseEntity.notFound().build() : ResponseEntity.ok(room);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/rooms/{code}/exist")
    public ResponseEntity<Boolean> isRoomExist(@PathVariable(required = true) String code) {
        return ResponseEntity.ok(roomService.existsByCode(code));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/rooms")
    public ResponseEntity<String> createRoom(@RequestBody Room room) {
        if (roomService.existsByTitle(room.getTitle()) || isBlank(room.getTitle())) {
            return ResponseEntity.badRequest().body("Title is null or not unique");
        }
        return ResponseEntity.ok(roomService.createRoom(room));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/rooms/{code}")
    public ResponseEntity<Void> deleteRoom(@PathVariable(required = true) String code) {
        if (roomService.existsByCode(code)) {
            roomService.deleteByCode(code);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
