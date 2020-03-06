package com.yosep.filemover;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystemWrapper {
    public List<File> getNewFiles(String directoryPath) throws IOException {
        return Files.walk(Paths.get(directoryPath))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

    public void moveFile(String fromPath, String toPath) throws IOException {
        Files.move(Paths.get(fromPath), Paths.get(toPath));
    }
}
