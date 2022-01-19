import java.util.Arrays;
import java.util.Scanner;

public class Game implements IGame {
    private int tries;
    private final Word word;
    private String[] output;
    private boolean win;
    private boolean valid;

    public Game(String word) {
        this.word = new Word(word);
        tries = 0;
        win = false;
        output = new String[this.word.getLength()];
    }

    @Override
    public void gameLoop() {
        while (tries < 6) {
            valid = false;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Guess: ");
            String input = scanner.nextLine();
            guess(input);
            if (win) {
                System.out.println(Arrays.toString(output));
                tries = 6;
            } else {
                if (valid) {
                    System.out.println(Arrays.toString(output));
                }
                tries++;
            }
        }
    }

    @Override
    public void guess(String input) {
        output = input.split("");
        if (input.length() == word.getLength()) {
            String[] guess = input.split("");
            for (int i = 0; i <= word.getWordArray().length - 1; i++) {
                if (guess[i].equalsIgnoreCase(word.getWordArray()[i])) {
                    output[i] = "[" + guess[i] + "]";
                    continue;
                } else {
                    for (int x = 0; x <= word.getWordArray().length - 1; x++) {
                        if (guess[i].equalsIgnoreCase(word.getWordArray()[x])) {
                            output[i] = "{" + guess[i] + "}";
                            break;
                        }
                    }
                }
            }
            valid = true;
            if (input.equalsIgnoreCase(word.getWordString())) {
                win = true;
                return;
            }
        } else {
            System.out.println("Word length incorrect, try again");
            tries--;
        }
    }

    public String getOutputString() {
        return Arrays.toString(output);
    }
}
