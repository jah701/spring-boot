package com.spring.boot.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomFileReaderImplTest {
    private static final String WRONG_PATH = "";
    private static final String EMPTY_PATH =
            "src/test/java/com/spring/boot/resources/empty-file.txt";

    private static CustomFileReader customFileReader;

    @BeforeAll
    static void beforeAll() {
        customFileReader = new CustomFileReaderImpl();
    }

    @Test
    public void wrongPathTest() {
        Assertions.assertThrows(RuntimeException.class,() -> customFileReader.readFile(WRONG_PATH));
    }

    @Test
    public void emptyFileRead() {
        Assertions.assertThrows(RuntimeException.class,() -> customFileReader.readFile(EMPTY_PATH));
    }
}
