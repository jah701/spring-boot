package util;

import static org.mockito.Mockito.when;

import com.spring.boot.repository.ProductRepository;
import com.spring.boot.service.ProductService;
import com.spring.boot.service.impl.ProductServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProductServiceImplTest {
    private static ProductService productService;

    @BeforeAll
    static void beforeAll() {
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void getMostCommentedProducts_ok() {
        List<String> actual = List.of("Product1", "Product2", "Product3");
        when(productService.getMostCommentedProducts(3)).thenReturn(actual);
        Assertions.assertEquals(3, productService.getMostCommentedProducts(3).size());
    }
}
