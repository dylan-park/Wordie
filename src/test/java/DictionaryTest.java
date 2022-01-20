import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DictionaryTest {
    private Dictionary dictionary;

    @Before
    public void setup() {
        dictionary = new Dictionary("src/test/resources/dictionary.txt");
    }

    @Test
    public void dictionaryConstruction() {
        assertNotNull(dictionary);
        assertNotNull(dictionary.getDictionaryArray());
        assertEquals(4, dictionary.getDictionaryArray().size());
    }

    @Test
    public void getTotalLineNumbers() {
        assertEquals(4L, dictionary.getTotalLineNumbers());
    }

    @Test
    public void getWordFromLineNumber() {
        assertEquals("hello", dictionary.getWordFromLineNumber(3));
    }
}
