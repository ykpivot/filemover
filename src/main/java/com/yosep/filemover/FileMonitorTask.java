package com.yosep.filemover;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileMonitorTask {

    private FileMonitor fileMonitor;

    public FileMonitorTask(FileMonitor fileMonitor) {
        this.fileMonitor = fileMonitor;
    }

    @Scheduled(fixedDelay = 1000)
    public void scheduled() {
        this.fileMonitor.process();
    }
}
