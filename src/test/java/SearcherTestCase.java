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
        void searchExactPhraseTestEncontrada() {
           
            List<String> list = List.of("apple", "cupra", "pelota");
            assertTrue(searcher.searchExactPhrase("apple", list));
        }
         @Test
        void searchExactPhraseTestNoEncontrada() {
            List<String> list = List.of("gol", "mundial", "hola");
            assertFalse(searcher.searchExactPhrase("date", list));
        }
        @Test   
        void getWordByIndexTestCorrecto(){
            List<String> list = List.of("moto", "coche", "raton");
            assertEquals("coche", searcher.getWordByIndex(list, 1));
        }
        @Test 
        void getWordByIndexTestIncorrecto(){
            List<String> list = List.of("perro", "coche", "adios");
            assertEquals(null, searcher.getWordByIndex(list, 5));
        }
        @Test   
        void searchByPrefixTestEncontrada(){
            List<String> list = List.of("cr7", "coche", "adios");
            List<String> expected = List.of("cr7");
            assertEquals(expected, searcher.searchByPrefix("cr", list));
        }
        @Test
        void searchByPrefixTestNoIncluido(){
            List<String> list = List.of("cr7", "coche", "adios");
            List<String> expected = List.of();
            assertEquals(expected, searcher.searchByPrefix("hola", list));
        }
        @Test
        void filterByKeywordTestDevuelto(){
            List<String> list = List.of("cr7", "coche", "adios");
            List<String> expected = List.of("coche");
            assertEquals(expected, searcher.filterByKeyword("che", list));
        }
        @Test 
        void filterByKeywordTestNoDevuelto(){
            List<String> list = List.of("cr7", "coche", "adios");
            List<String> expected = List.of();
            assertEquals(expected, searcher.filterByKeyword("oleee", list));
        }
        @Test 
         void searchExactPhraseTestEncontrada1() {
            List<String> list = List.of("apple", "cupra", "pelota");
            assertTrue(searcher.searchExactPhrase("cupra", list));
         }  //el fallo es que el metodo de la clase Searcher solo lee la primera palabra de la lista y no recorre toda la lista para buscar la palabra exacta,por eso el test falla.
         //tengo que modificar el metodo searchExactPhrase de la clase Searcher de modo que pueda recorrer toda la lista y buscar la palabra exacta, no solo la primera palabra de la lista.

         @Test
         void searchExactPhraseTestEncontrada2() {
            List<String> list = List.of("apple", "cupra", "pelota");
            assertTrue(searcher.searchExactPhrase("cupra", list));  //tras cambiar el metodo de la clase Searcher el test ya funciona.
}
}

    

