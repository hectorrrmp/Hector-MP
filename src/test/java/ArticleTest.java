import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import com.prueba1.*;
import com.prueba1.model.Article;

public class ArticleTest {
    public Article article;

    @BeforeEach 
    public void setUp() {
        article = new Article("Articulo1", 2, 50.0, 10.0);
    }
    @Test 
    void getGrossAmountTest() {
        assertEquals(100.0, article.getGrossAmount(article.getCantidad(), article.getPrecio()));
    }
    @Test
    void getDiscountedAmountTest() {
        double grossAmount = article.getGrossAmount(article.getCantidad(), article.getPrecio());
        assertEquals(90.0, article.getDiscountedAmount(grossAmount, article.getDescuento()));
    }
}
