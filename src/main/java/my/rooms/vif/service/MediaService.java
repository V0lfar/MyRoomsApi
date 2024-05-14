package my.rooms.vif.service;

import my.rooms.vif.model.Monitor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MediaService {

    private static final String MEDIA_LOCATION = "media/room/";
    private static final String MONITOR = "/monitor/";

    public Resource getResourceForMonitor(Monitor monitor) throws MalformedURLException {
        Path path = Paths.get(monitor.getUrl());
        return new UrlResource(path.toUri());
    }

    public void createMedia(Monitor monitor) throws IOException {
        Path path = Paths.get(MEDIA_LOCATION + monitor.getRoom().getCode() + MONITOR + monitor.getFileName());
        Files.write(path, monitor.getFile());
    }

    public void cleanFolder(Path path) {
        try {
            FileUtils.deleteDirectory(path.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong during folder cleanup...");
        }
    }

    public void cleanMedia(List<Monitor> monitors) {
        monitors.forEach(this::cleanMedia);
    }

    private void cleanMedia(Monitor monitor) {
        Path path = Paths.get(MEDIA_LOCATION + monitor.getRoom().getCode() + MONITOR + monitor.getFileName());
        try {
            if (!Files.exists(path)) {
                return;
            }
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong during monitor cleanup...");
        }
    }
}
