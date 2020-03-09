package com.yosep.filemover.watcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MonitorConfig {
    private boolean doNotProcessLargeFile;
}
