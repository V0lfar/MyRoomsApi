package my.rooms.vif.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.rooms.vif.model.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findByCode(String code);

    List<Room> findByTitleContainingOrCodeContaining(String termTitle, String termCode, Sort sort);

    boolean existsByCode(String code);

    boolean existsByTitle(String title);

    void deleteByCode(String code);
}
