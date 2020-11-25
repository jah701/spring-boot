import static org.mockito.Mockito.when;

import com.spring.boot.repository.CommentRepository;
import com.spring.boot.service.CommentService;
import com.spring.boot.service.impl.CommentServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommentServiceImplTest {
    private static CommentService commentService;
    private static CommentRepository commentRepository;

    @BeforeAll
    static void beforeAll() {
        commentRepository = Mockito.mock(CommentRepository.class);
        commentService = new CommentServiceImpl(commentRepository);
    }

    @Test
    public void outputListSize_ok() {
        List<String> tempList = List.of("the ", "and ", "this ", "a ",
                "it ", "i ", "taffy ", "is ", "was ", "very ", "of ");
        when(commentService.getMostUsedWordsFromComments(11)).thenReturn(tempList);
        List<String> actual = commentService.getMostUsedWordsFromComments(11);
        Assertions.assertEquals(11, actual.size());
    }
}
