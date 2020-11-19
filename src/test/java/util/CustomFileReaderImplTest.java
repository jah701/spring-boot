package util;

import com.spring.boot.util.CustomFileReader;
import com.spring.boot.util.CustomFileReaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomFileReaderImplTest {
    private static final String WRONG_PATH = "";
    private static final String CORRECT_PATH = "src/test/java/resources/file.csv";

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
    public void correctPathTest() {
        Assertions.assertEquals(10, customFileReader.readFile(CORRECT_PATH).size());
    }
}
