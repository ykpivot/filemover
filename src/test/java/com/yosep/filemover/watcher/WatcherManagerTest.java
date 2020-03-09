package com.yosep.filemover.watcher;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

class WatcherManagerTest {
    @Test
    void createAndStartWatchers() {
        WatcherFactory factory = mock(WatcherFactory.class);

        FileWatcher firstWatcher = mock(FileWatcher.class);
        FileWatcher secondWatcher = mock(FileWatcher.class);

        when(factory.create()).thenReturn(
                Arrays.asList(
                        firstWatcher,
                        secondWatcher
        ));

        WatcherManager manager = new WatcherManager(factory);

        manager.start();

        verify(firstWatcher, times(1)).start();
        verify(secondWatcher, times(1)).start();
    }
}