package com.spring.boot.event;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class StartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    @Value("${csv.file.url}")
    private String csvFileUrl;
    @Value("${load.into.path}")
    private String loadedFile;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("Startup Event method onApplicationEvent() started . . .");
        loadCsvFile(csvFileUrl, loadedFile);
        log.info("Startup Event method onApplicationEvent() finished successfully");
    }

    public boolean loadCsvFile(String url, String intoPath) {
        try (BufferedInputStream urlReader = new BufferedInputStream(new URL(url).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(intoPath)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = urlReader.read(dataBuffer)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't load CSV file from: ' " + url + " '", e);
        }
        return true;
    }
}
