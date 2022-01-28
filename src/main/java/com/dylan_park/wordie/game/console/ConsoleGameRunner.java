package com.dylan_park.wordie.game.console;

import com.dylan_park.wordie.data.Dictionary;
import com.dylan_park.wordie.game.IGame;

public class ConsoleGameRunner {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");
        Dictionary bank = new Dictionary("src/main/resources/bank.txt");
        IGame consoleGame = new ConsoleGame(dictionary, bank);
        consoleGame.gameLoop();
    }
}
