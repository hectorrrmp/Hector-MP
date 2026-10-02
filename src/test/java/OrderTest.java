import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import com.prueba1.*;
import com.prueba1.model.Order;

public class OrderTest {
    public Order order;

    @BeforeEach 
    public void setUp() {
        List<String> articulos = List.of("Articulo1", "Articulo2");
        order = new Order("Pedido1", articulos);
    }
    @Test 
    void getGrossTotalTest() {
        List<Double> amounts = List.of(100.0, 200.0, 300.0);
        assertEquals(600.0, order.getGrossTotal(amounts));
    }
    @Test
    void getDiscountedTotalTest() {
        double grossTotal = 600.0;
        double discount = 10.0;
        assertEquals(540.0, order.getDiscountedTotal(grossTotal, discount));
    }



}
