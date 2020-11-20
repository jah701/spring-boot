package util;

import com.spring.boot.util.CustomFileReader;
import com.spring.boot.util.CustomFileReaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomFileReaderImplTest {
    private static final String WRONG_PATH = "";
    private static final String EMPTY_PATH =
            "src/test/java/resources/empty-file.txt";

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
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> customFileReader.readFile(EMPTY_PATH).get(0));
        Assertions.assertEquals(0, customFileReader.readFile(EMPTY_PATH).size());
    }
}
