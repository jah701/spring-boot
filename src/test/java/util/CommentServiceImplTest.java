package util;

import com.spring.boot.repository.CommentRepository;
import com.spring.boot.service.CommentService;
import com.spring.boot.service.impl.CommentServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

class CommentServiceImplTest {
    private static CommentService commentService;
    private static CommentRepository commentRepository;

    @BeforeAll
    static void beforeAll() {
        commentRepository = Mockito.mock(CommentRepository.class);
        commentService = new CommentServiceImpl(commentRepository);
    }
}
