package com.dylan_park.wordie.game.web;

import com.dylan_park.wordie.data.Dictionary;
import com.dylan_park.wordie.data.Word;
import com.dylan_park.wordie.game.IGame;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Random;

@SpringBootApplication
public class WebGame implements IGame {
    private int tries;
    private final Word word;
    private final ArrayList<String> bank;
    private String[] output;
    private boolean win;
    private boolean valid;
    private static final Logger logger = LoggerFactory.getLogger(WebGame.class);

    public static void main(String[] args) {
        SpringApplication.run(WebGame.class, args);
    }


    public WebGame(@NotNull Dictionary dictionary, @NotNull Dictionary bank) {
        this.word = new Word(dictionary.getDictionaryArray().get(new Random().nextInt(dictionary.getDictionaryArray().size())));
        this.bank = bank.getDictionaryArray();
        tries = 0;
        win = false;
        output = new String[this.word.getLength()];
    }

    @Override
    public void gameLoop() {

    }

    @Override
    public void guess(String input) {

    }

    public Word getWord() {
        return word;
    }
}
