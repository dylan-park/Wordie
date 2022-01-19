import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DictionaryTest {
    private Dictionary dictionary;

    @Before
    public void setup(){
        dictionary = new Dictionary("src/test/resources/dictionary.txt");
    }

    @Test
    public void getTotalLineNumbers(){
        assertEquals(4L, dictionary.getTotalLineNumbers());
    }

    @Test
    public void getWordFromLineNumber(){
        assertEquals("Hello", dictionary.getWordFromLineNumber(3));
    }
}
