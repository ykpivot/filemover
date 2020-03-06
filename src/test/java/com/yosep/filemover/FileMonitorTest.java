package com.yosep.filemover;

import org.assertj.core.util.Files;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class FileMonitorTest {
    @TempDir
    File tempDirectory;

    @Test
    void moveFileWhenNewFileIsAdded() throws IOException {
        File firstFile = new File(tempDirectory, "dummy-file.txt");
        String tempFolderPath = tempDirectory.getAbsolutePath();
        String inputFolder = tempFolderPath + "/input-folder";
        String outputFolder = tempFolderPath + "/output-folder";

        List<File> files = Arrays.asList(firstFile);

        FileMonitorConfig fileMonitorConfig = mock(FileMonitorConfig.class);
        when(fileMonitorConfig.getInputFolder()).thenReturn(inputFolder);
        when(fileMonitorConfig.getOutputFolder()).thenReturn(outputFolder);

        FileSystemWrapper fileSystemWrapper = mock(FileSystemWrapper.class);
        when(fileSystemWrapper.getNewFiles()).thenReturn(files);

        FileMonitor fileMonitor = new FileMonitor(fileMonitorConfig, fileSystemWrapper);

        fileMonitor.process();

        verify(fileSystemWrapper).moveFile(
                inputFolder + "/dummy-file.txt",
                outputFolder + "/dummy-file.txt");
    }
}