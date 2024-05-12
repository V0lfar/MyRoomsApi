package my.rooms.vif.service;

import my.rooms.vif.model.Monitor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class MediaService {

    public Resource getResourceForMonitor(Monitor monitor) throws MalformedURLException {
        Path path = Paths.get(monitor.getUrl());
        return new UrlResource(path.toUri());
    }
}
