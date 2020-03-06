package com.yosep.filemover;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FileMonitorTaskTest {

    @Test
    void runFileMonitorWhenSchedulerKicksOff() throws IOException {
        FileMonitor fileMonitor = mock(FileMonitor.class);

        FileMonitorTask task = new FileMonitorTask(fileMonitor);

        task.scheduled();

        verify(fileMonitor).process();
    }
}