package com.yosep.filemover;

import java.io.File;
import java.util.List;

public class FileMonitor {

    private FileMonitorConfig fileMonitorConfig;
    private FileSystemWrapper fileSystemWrapper;

    public FileMonitor(FileMonitorConfig fileMonitorConfig, FileSystemWrapper fileSystemWrapper) {
        this.fileMonitorConfig = fileMonitorConfig;
        this.fileSystemWrapper = fileSystemWrapper;
    }

    public void process() {
        List<File> files = this.fileSystemWrapper.getNewFiles(fileMonitorConfig.getInputFolder());

        for (File file: files) {
            String fileName = file.getName();
            this.fileSystemWrapper.moveFile(
                    this.fileMonitorConfig.getInputFolder() + "/" + fileName,
                    this.fileMonitorConfig.getOutputFolder() + "/" + fileName);
        }
    }
}
