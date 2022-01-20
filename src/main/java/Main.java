public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");
        Dictionary bank = new Dictionary("src/main/resources/bank.txt");
        IGame consoleGame = new ConsoleGame(dictionary, bank);
        consoleGame.gameLoop();
    }
}
