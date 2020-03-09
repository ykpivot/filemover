package com.yosep.filemover.watcher;

import java.util.ArrayList;
import java.util.List;

public class WatcherFactory {
    private BankService bankService;
    private MonitorConfig monitorConfig;

    public WatcherFactory(BankService bankService, MonitorConfig monitorConfig) {
        this.bankService = bankService;
        this.monitorConfig = monitorConfig;
    }

    public List<FileWatcher> create() {
        List<FileWatcher> watchers = new ArrayList<>();

        for (Bank bank : this.bankService.getBanks()) {
            FileWatcher watcher = new FileWatcher(bank.getBankId(), this.monitorConfig.isDoNotProcessLargeFile());
            watchers.add(watcher);
        }
        return watchers;
    }
}
