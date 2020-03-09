package com.yosep.filemover.watcher;

import java.util.List;

public class WatcherManager {
    private WatcherFactory watcherFactory;

    public WatcherManager(WatcherFactory watcherFactory) {

        this.watcherFactory = watcherFactory;
    }

    public void start() {
        List<FileWatcher> watchers = this.watcherFactory.create();

        for (FileWatcher watcher : watchers) {
            watcher.start();
        }
    }
}
