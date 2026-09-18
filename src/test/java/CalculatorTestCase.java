import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

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
     @Test
      void multiplyTestCero() {
        assertEquals(0, calculator.multiply(2,0));
      }
       @Test
      void multiplyTestNegativo() {
        assertEquals(-6, calculator.multiply(-2,3));
      }
       @Test
      void ConcatTestNormal() {
        assertEquals("33", calculator.concat( "3", "3"));
      }
      @Test
      void ConcatTestnull() {
        assertEquals("empty", calculator.concat( "3",null ));
      }
      @Test
      void sumTestNormal() {
        assertEquals(6, calculator.sum( 3,3 ));
      }
       @Test
      void sumTestNegativo() {
        assertEquals(-6, calculator.sum( -3,-3 ));
      }
       @Test
      void discountTestNormal() {
        assertEquals(80, calculator.discount( 100,20 ));
      }
       @Test
      void discountTestCero() {
        assertEquals(100, calculator.discount( 100,0));
      }
        @Test
      void discountTestCien() {
        assertEquals(0, calculator.discount( 100,100));
      }
        @Test
      void discountTestInvalido() {
        assertThrows(IllegalArgumentException.class, () -> calculator.discount( 100,1000));
      }
      @Test
      void calculateTotalTestNormal() {
        List<Double> amounts = List.of(10.0, 20.0, 30.0);
        assertEquals(60.0, calculator.calculateTotal(amounts));
      }
      @Test 
      void calculateTotalTestEmpty() {
          List<Double> amounts = List.of();
          assertEquals(0.0, calculator.calculateTotal(amounts));
        }
     }