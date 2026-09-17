import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.BeforeEach;

import com.prueba1.*;
    
     public class CalculatorTestCase{
        
        public Calculator calculator;

        @BeforeEach
        public void setUp(){
            calculator =new Calculator();

        }
      @Test
      void multiplyTest() {
        assertEquals(6, calculator.multiply(2,3));
      }

     }