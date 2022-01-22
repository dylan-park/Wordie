package com.dylan_park.wordie.game;

import com.dylan_park.wordie.data.Dictionary;
import com.dylan_park.wordie.game.console.ConsoleGame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Dictionary dictionary, bank;

    @Before
    public void setup() {
        dictionary = new Dictionary("src/test/resources/singleDictionary.txt");
        bank = new Dictionary("src/test/resources/bank.txt");
    }

    @Test
    public void guessCorrectTest() {
        ConsoleGame game = new ConsoleGame(dictionary, bank);
        game.guess("dog");
        assertEquals("[[d], [o], [g]]", game.getOutputString());
    }

    @Test
    public void guessMixTest() {
        ConsoleGame game = new ConsoleGame(dictionary, bank);
        game.guess("god");
        assertEquals("[{g}, [o], {d}]", game.getOutputString());
    }

    @Test
    public void guessIncorrectTest() {
        ConsoleGame game = new ConsoleGame(dictionary, bank);
        game.guess("abc");
        assertEquals("[a, b, c]", game.getOutputString());
    }

    @Test
    public void guessInvalidTest() {
        ConsoleGame game = new ConsoleGame(dictionary, bank);
        game.guess("do");
        assertEquals("[d, o]", game.getOutputString());
    }
}
