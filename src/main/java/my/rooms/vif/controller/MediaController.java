package my.rooms.vif.controller;

import my.rooms.vif.model.Monitor;
import my.rooms.vif.service.MediaService;
import my.rooms.vif.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
public class MediaController {

    @Autowired
    private MonitorService monitorService;
    @Autowired
    private MediaService mediaService;

    @GetMapping("/monitor/{id}")
    public ResponseEntity<Resource> getMonitorMedia(@PathVariable(required = true) Long id) throws MalformedURLException {
        final Monitor monitor = monitorService.getMonitorById(id);
        Resource resource = mediaService.getResourceForMonitor(monitor);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
