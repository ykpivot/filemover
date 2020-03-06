package com.yosep.filemover;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileMonitorConfig {

    @Value("${input.folder}")
    private String inputFolder;

    @Value("${output.folder}")
    private String outputFolder;

    public String getInputFolder() {
        return this.inputFolder;
    }

    public String getOutputFolder() {
        return this.outputFolder;
    }
}
