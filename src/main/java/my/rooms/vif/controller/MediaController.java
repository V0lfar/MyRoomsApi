package my.rooms.vif.controller;

import my.rooms.vif.model.Monitor;
import my.rooms.vif.service.MediaService;
import my.rooms.vif.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@RestController
public class MediaController {

    @Autowired
    private MonitorService monitorService;
    @Autowired
    private MediaService mediaService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/monitor/{id}")
    public ResponseEntity<Resource> getMonitorMedia(@PathVariable(required = true) Long id,
                                                    @RequestParam(defaultValue = "false") boolean attachment) throws MalformedURLException {
        final Monitor monitor = monitorService.getMonitorById(id);
        Resource resource = mediaService.getResourceForMonitor(monitor);
        String disposition = attachment ? "inline" : "attachment";
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, disposition + "; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
