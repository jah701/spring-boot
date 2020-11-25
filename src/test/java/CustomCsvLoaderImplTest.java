import com.spring.boot.util.CustomCsvLoader;
import com.spring.boot.util.CustomCsvLoaderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomCsvLoaderImplTest {
    private static final String WRONG_URL = "";
    private static final String WRONG_PATH = "";
    private static final String CORRECT_URL
            = "https://spring-boot-aws-revievers.s3.eu-central-1.amazonaws.com/Reviews.csv";
    private static final String CORRECT_INTO_PATH = "src/test/java/resources/into-file.csv";
    private static CustomCsvLoader customCsvLoader;

    @BeforeAll
    public static void beforeAll() {
        customCsvLoader = new CustomCsvLoaderImpl();
    }

    @Test
    public void setWrongPathTest() {
        Assertions.assertThrows(RuntimeException.class,
                () -> customCsvLoader.loadCsvFile(WRONG_URL, WRONG_PATH));
    }

    @Test
    public void correctPathTest() {
        Assertions.assertTrue(customCsvLoader.loadCsvFile(CORRECT_URL, CORRECT_INTO_PATH));
    }
}
