package my.rooms.vif.repository;

import my.rooms.vif.model.Monitor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends ListCrudRepository<Monitor, Long> {
}
