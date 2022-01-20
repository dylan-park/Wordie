package com.dylan_park.wordie.game;

import com.dylan_park.wordie.data.Dictionary;
import com.dylan_park.wordie.data.Word;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static spark.Spark.*;

public class WebGame implements IGame {
    private int tries;
    private final Word word;
    private final ArrayList<String> bank;
    private String[] output;
    private boolean win;
    private boolean valid;
    private static Map map = new HashMap();
    private static final Logger logger = LoggerFactory.getLogger(WebGame.class);

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");
        Dictionary bank = new Dictionary("src/main/resources/bank.txt");
        get("/", (rq, rs) -> {
            IGame webGame = new WebGame(dictionary, bank);
            ((WebGame) webGame).loadMap();
            return new ThymeleafTemplateEngine().render(
                    new ModelAndView(map, "webGame")
                    );
        });
    }

    public void loadMap() {
        for (int i = 0; i < this.word.getWordArray().length; i++) {
            map.put("letter" + i, this.word.getWordArray()[i]);
        }
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
}
