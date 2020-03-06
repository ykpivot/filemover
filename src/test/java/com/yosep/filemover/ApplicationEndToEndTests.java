package com.yosep.filemover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class ApplicationEndToEndTests {

    @BeforeEach
    void setUp() throws IOException {
        if (Files.exists(Paths.get("files/input/input1.txt"))) {
            Files.delete(Paths.get("files/input/input1.txt"));
        }
    }

    @Test
    void shouldStartProcessFilesWhenAppStarts() throws IOException, InterruptedException {
        Files.copy(Paths.get("files/original/input1.txt"), Paths.get("files/input/input1.txt"));

        Thread.sleep(1000);

        boolean fileExists = Files.exists(Paths.get("files/output/input1.txt"));

        assertTrue(fileExists);
    }
}
