package com.palvair;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class FileImprovementsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileImprovementsTest.class);

    @Test
    public void should_write_and_read_string() throws IOException {
        final String fileContent = writeThenRead("Hello World");

        assertThat(fileContent).isEqualTo("Hello World");
    }

    private String writeThenRead(final String value) throws IOException {
        final Path tempFile = Files.createTempFile("demo", ".txt");
        final Path filePath = Files.writeString(tempFile, value);
        LOGGER.debug("File path = [{}]", filePath);
        return Files.readString(filePath);
    }
}
