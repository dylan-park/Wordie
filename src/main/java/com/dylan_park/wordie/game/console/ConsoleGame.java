package com.dylan_park.wordie.game.console;

import com.dylan_park.wordie.data.Dictionary;
import com.dylan_park.wordie.data.Word;
import com.dylan_park.wordie.game.IGame;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ConsoleGame implements IGame {
    private int tries;
    private boolean valid;
    private final Word word;
    private final ArrayList<String> bank;
    private String[] output;
    private boolean win;


    public ConsoleGame(@NotNull Dictionary dictionary, @NotNull Dictionary bank) {
        this.word = new Word(dictionary.getDictionaryArray().get(new Random().nextInt(dictionary.getDictionaryArray().size())));
        this.bank = bank.getDictionaryArray();
        tries = 0;
        win = false;
        output = new String[this.word.getLength()];
    }

    @Override
    public void gameLoop() {
        // Tries instantiated at 0, meaning 6 tries
        while (tries < 6) {
            valid = false;
            // Get guess
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Guess: ");
            String input = scanner.nextLine();
            guess(input);
            stateCheck(win, valid, tries);
        }
    }


    @Override
    public void guess(@NotNull String input) {
        // Set the output to the input before any checks, so entire word is shown. This also marks letters as "Gray"
        output = input.split("");
        // If word is correct length
        if (input.length() == word.getLength() && bank.stream().anyMatch(input::equalsIgnoreCase)) {
            valid = true;
            // Split input into the guess array
            String[] guess = input.split("");
            // Loops through each letter of the game word
            for (int i = 0; i <= word.getWordArray().length - 1; i++) {
                // Does this letter of the guess word match the game word at the same index
                if (guess[i].equalsIgnoreCase(word.getWordArray()[i])) {
                    // Mark output letter "Green"
                    output[i] = "[" + guess[i] + "]";
                    // Else letter does not match
                } else {
                    // Inner loop goes through all letters of game word again
                    for (int x = 0; x <= word.getWordArray().length - 1; x++) {
                        // Does this letter of the guess word exist in the game word
                        if (guess[i].equalsIgnoreCase(word.getWordArray()[x])) {
                            // Mark output "Yellow"
                            output[i] = "{" + guess[i] + "}";
                            break;
                        }
                    }
                }
            }
            // Check if user is correct
            if (input.equalsIgnoreCase(word.getWordString())) {
                win = true;
            }
            // If word is incorrect length
        } else {
            invalidGuess();
        }
    }

    @Override
    public void validGuess() {
        System.out.println(Arrays.toString(output));
        tries++;
    }

    @Override
    public void invalidGuess() {
        System.out.println("Word is invalid, try again");
    }

    @Override
    public void winGame() {
        System.out.println(Arrays.toString(output));
        tries = 7;
    }

    @Override
    public void loseGame() {
        System.out.println("Game Over! The word was: " + word.getWordString());
    }

    public String getOutputString() {
        return Arrays.toString(output);
    }
}
