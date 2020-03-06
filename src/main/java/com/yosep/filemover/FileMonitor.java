package com.yosep.filemover;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class FileMonitor {

    private FileMonitorConfig fileMonitorConfig;
    private FileSystemWrapper fileSystemWrapper;

    @Autowired
    public FileMonitor(FileMonitorConfig fileMonitorConfig, FileSystemWrapper fileSystemWrapper) {
        this.fileMonitorConfig = fileMonitorConfig;
        this.fileSystemWrapper = fileSystemWrapper;
    }

    public void process() throws IOException {
        List<File> files = this.fileSystemWrapper.getNewFiles(fileMonitorConfig.getInputFolder());

        for (File file: files) {
            String fileName = file.getName();
            this.fileSystemWrapper.moveFile(
                    this.fileMonitorConfig.getInputFolder() + "/" + fileName,
                    this.fileMonitorConfig.getOutputFolder() + "/" + fileName);
        }
    }
}
