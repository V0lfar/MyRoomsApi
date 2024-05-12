package my.rooms.vif.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import my.rooms.vif.model.Room;

@Repository
public interface RoomRepository extends ListCrudRepository<Room, Long> {
    
    Room findByCode(String code);
}
