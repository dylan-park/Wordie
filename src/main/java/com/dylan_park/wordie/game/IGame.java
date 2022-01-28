package com.dylan_park.wordie.game;

public interface IGame {

    /**
     * Primary game loop. Should contain a loop through tries, setting of valid to false, getting guess input, then passing that to guess, as well as checking states.
     */
    void gameLoop();

    default void stateCheck(boolean win, boolean valid, int tries) {
        // If win was set in the guess, Display output and break loop (Beyond 6 for future check)
        if (win) {
            winGame();
            // If answer was otherwise valid, display the output and increment tries
        } else {
            if (valid) {
                validGuess();
            }
        }
        // If user has 6 tries the game is over naturally, display message and word and loop ends
        if (tries == 5) {
            loseGame();
        }
    }

    void guess(String input);

    void validGuess();

    void invalidGuess();

    void winGame();

    void loseGame();
}
