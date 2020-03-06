package com.yosep.filemover;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemWrapperTest {

    @Test
    void getFiles() throws IOException {
        FileSystemWrapper wrapper = new FileSystemWrapper();
        List<File> files = wrapper.getNewFiles("files/original");

        assertEquals(1, files.size());
        assertEquals("input1.txt", files.get(0).getName());
    }

    @Test
    void moveFileFromOneLocationToAnother() throws IOException {
        FileSystemWrapper wrapper = new FileSystemWrapper();

        String fileName = String.format("%s.txt", UUID.randomUUID());
        String inputFile = String.format("files/input/%s", fileName);
        String outputFile = String.format("files/output/%s", fileName);

        File inputFileObject = new File(inputFile);
        inputFileObject.createNewFile();

        assertFalse(Files.exists(Paths.get(outputFile)));

        wrapper.moveFile(inputFile, outputFile);

        assertTrue(Files.exists(Paths.get(outputFile)));

        Files.delete(Paths.get(outputFile));
    }
}