package com.yosep.filemover.watcher;

import com.yosep.filemover.FileMonitor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WatcherFactoryTest {
    @Test
    void createWatchers() {
        BankService bankService =  mock(BankService.class);
        MonitorConfig monitorConfig = mock(MonitorConfig.class);

        when(bankService.getBanks()).thenReturn(
                Arrays.asList(
                    new Bank(120),
                    new Bank(230),
                    new Bank(400)
                ));

        when(monitorConfig.isDoNotProcessLargeFile()).thenReturn(true);

        WatcherFactory factory = new WatcherFactory(bankService, monitorConfig);

        List<FileWatcher> watchers = factory.create();

        assertEquals(3, watchers.size());
        assertEquals(120, watchers.get(0).getBankId());
        assertTrue(watchers.get(0).isSkipLargeFile());
        assertEquals(230, watchers.get(1).getBankId());
        assertTrue(watchers.get(1).isSkipLargeFile());
        assertEquals(400, watchers.get(2).getBankId());
        assertTrue(watchers.get(2).isSkipLargeFile());
    }
}