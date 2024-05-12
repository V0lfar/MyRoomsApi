package my.rooms.vif.service;

import my.rooms.vif.model.Monitor;
import my.rooms.vif.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {

    @Autowired
    private MonitorRepository monitorRepository;

    public Monitor getMonitorById(Long id) {
        return monitorRepository.findById(id).orElse(null);
    }
}
