import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");
        Game game = new Game(dictionary.getWordFromLineNumber(new Random().nextInt(((int) dictionary.getTotalLineNumbers()) - 1) + 1));
        game.gameLoop();
    }
}
