package util;

import com.spring.boot.dto.ReviewDto;
import com.spring.boot.util.CustomCsvParser;
import com.spring.boot.util.CustomCsvParserImpl;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomCsvParserImplTest {
    private static final String WRONG_PATH = "";
    private static final String FILE_CSV = "src/test/java/resources/file.csv";

    private static CustomCsvParser customCsvParser;

    @BeforeAll
    static void beforeAll() {
        customCsvParser = new CustomCsvParserImpl();
    }

    @Test
    public void wrongPathTest() {
        Assertions.assertThrows(RuntimeException.class,
                () -> customCsvParser.csvToReview(WRONG_PATH));
    }

    @Test
    public void countLinesFromFileTest() {
        List<ReviewDto> reviews = customCsvParser.csvToReview(FILE_CSV);
        Assertions.assertEquals(9, reviews.size());
    }

    @Test
    public void testCreatedFromCsvObjects() {
        List<ReviewDto> reviews = customCsvParser.csvToReview(FILE_CSV);
        ReviewDto review = reviews.get(0);
        Assertions.assertEquals("delmartian", review.getProfileName());
        Assertions.assertEquals(LocalDateTime.parse("1970-01-16T05:11:02.400"), review.getTime());
        Assertions.assertEquals("A3SGXH7AUHU8GW", review.getUserId());
    }
}
