package com.yosep.filemover;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FileMonitorTask {

    private FileMonitor fileMonitor;

    public FileMonitorTask(FileMonitor fileMonitor) {
        this.fileMonitor = fileMonitor;
    }

    @Scheduled(fixedDelay = 1000)
    public void scheduled() throws IOException {
        this.fileMonitor.process();
    }
}
