package com.yosep.filemover.watcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileWatcher {
    private int bankId;
    private boolean skipLargeFile;
}
