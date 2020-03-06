package com.yosep.filemover;

import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestPropertySource;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
@TestPropertySource(locations = "/test.properties")
public class FileMonitorIntegrationTests {

    @SpyBean
    FileMonitorTask fileMonitorTask;

    @Test
    void monitorsInputFolderEverySecond() {
        await()
                .atMost(Duration.TWO_SECONDS)
                .untilAsserted(() -> verify(fileMonitorTask, atLeast(2)).scheduled());
    }
}
