package com.yosep.filemover;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileMonitorTask {

    @Scheduled(fixedDelay = 1000)
    public void scheduled() {
    }
}
