import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import com.prueba1.*;


public class SearcherTestCase {
    public Searcher searcher;
    
        @BeforeEach
        public void setUp(){
            searcher =new Searcher();
        }
        @Test
      void searchWord() {
         List<String> list = List.of("casa", "perro", "palabra");
        
          boolean resultado = searcher.searchWord("palabra", list);

    if (resultado) {
        System.out.println("Palabra encontrada");
    } else {
        System.out.println("Palabra no encontrada");
    }
        
        
  
        
      }

    
}
