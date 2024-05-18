package my.rooms.vif.service;

import my.rooms.vif.model.Monitor;
import my.rooms.vif.model.Room;
import my.rooms.vif.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class RoomService {

    private static final String MEDIA_LOCATION = "media/room/";
    private static final String MONITOR = "/monitor/";
    private static final Map<String, Sort> SORT_MAP = Map.of(
            "time-desc", Sort.by(Sort.Direction.DESC, "time"),
            "time-asc", Sort.by(Sort.Direction.ASC, "time"),
            "title-desc", Sort.by(Sort.Direction.DESC, "title"),
            "title-asc", Sort.by(Sort.Direction.ASC, "title"));

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private MediaService mediaService;

    public List<Room> getAllRooms(String sort) {
        return roomRepository.findAll(resolveSort(sort));
    }

    public Room getRoomByCode(String code) {
        return roomRepository.findByCode(code);
    }

    public List<Room> searchRoomByTerm(String term, String sort) {
        return roomRepository.findByTitleContainingOrCodeContaining(term, term, resolveSort(sort));
    }

    @Transactional
    public String createRoom(Room room) {
        List<Monitor> monitors = room.getMonitors();
        room.setTime(new Date());
        room.setCode(generateCode());
        try {
            for (Monitor monitor : monitors) {
                createRoomFolder(room);
                createMonitorFolder(room);
                mediaService.createMedia(monitor);
            }
            roomRepository.save(room);
            return room.getCode();
        } catch (IOException exception) {
            mediaService.cleanMedia(monitors);
            Paths.get(MEDIA_LOCATION + room.getCode()).toFile().delete();
            throw new RuntimeException("Something went wrong during monitor creation...");
        }
    }

    @Transactional
    public void deleteByCode(String code) {
        mediaService.cleanFolder(Paths.get(MEDIA_LOCATION + code));
        roomRepository.deleteByCode(code);
    }

    public Boolean existsByCode(String code) {
        return roomRepository.existsByCode(code);
    }

    public Boolean existsByTitle(String title) {
        return roomRepository.existsByTitle(title);
    }

    private void createMonitorFolder(Room room) throws IOException {
        Path path = Paths.get(MEDIA_LOCATION + room.getCode() + MONITOR);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    private void createRoomFolder(Room room) throws IOException {
        Path path = Paths.get(MEDIA_LOCATION + room.getCode());
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    private String generateCode() {
        String code;
        do {
            Random rnd = new Random();
            int number = rnd.nextInt(999999);
            code = String.format("%06d", number);
        } while (existsByCode(code));
        return code;
    }

    private Sort resolveSort(String sort) {
        return SORT_MAP.getOrDefault(sort, Sort.by(Sort.Direction.DESC, "time"));
    }
}
