package com.yosep.filemover;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
@ContextConfiguration(classes = FileMonitorConfig.class)
@TestPropertySource(locations = "/test.properties")
public class FileMonitorConfigIntegrationTests {

    @Autowired
    FileMonitorConfig fileMonitorConfig;

    @Test
    void populatesFileMonitorConfig() {
        assertEquals("files/input", fileMonitorConfig.getInputFolder());
        assertEquals("files/output", fileMonitorConfig.getOutputFolder());
    }
}
