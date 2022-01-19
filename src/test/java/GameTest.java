import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private final String key = "dog";

    @Test
    public void guessCorrectTest(){
        ConsoleGame game = new ConsoleGame(key);
        game.guess("dog");
        assertEquals("[[d], [o], [g]]", game.getOutputString());
    }

    @Test
    public void guessMixTest(){
        ConsoleGame game = new ConsoleGame(key);
        game.guess("god");
        assertEquals("[{g}, [o], {d}]", game.getOutputString());
    }

    @Test
    public void guessIncorrectTest(){
        ConsoleGame game = new ConsoleGame(key);
        game.guess("abc");
        assertEquals("[a, b, c]", game.getOutputString());
    }

    @Test
    public void guessInvalidTest(){
        ConsoleGame game = new ConsoleGame(key);
        game.guess("do");
        assertEquals("[d, o]", game.getOutputString());
    }
}
