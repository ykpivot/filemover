package com.yosep.filemover;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@TestPropertySource(locations = "/test.properties")
public class ApplicationEndToEndTests {

    @BeforeEach
    void setUp() throws IOException {
        cleanUpFileSystem();
    }

    @AfterEach
    void tearDown() throws IOException {
       cleanUpFileSystem();
    }

    @Test
    void shouldStartProcessFilesWhenAppStarts() throws IOException, InterruptedException {
        Files.copy(Paths.get("files/original/input1.txt"), Paths.get("files/input/input1.txt"));

        Thread.sleep(1000);

        boolean fileExists = Files.exists(Paths.get("files/output/input1.txt"));

        assertTrue(fileExists);
    }

    private void cleanUpFileSystem() throws IOException {
        if (Files.exists(Paths.get("files/input/input1.txt"))) {
            Files.delete(Paths.get("files/input/input1.txt"));
        }

        if (Files.exists(Paths.get("files/output/input1.txt"))) {
            Files.delete(Paths.get("files/output/input1.txt"));
        }
    }
}
