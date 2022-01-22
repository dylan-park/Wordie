package com.dylan_park.wordie.game.web.controllers;

import com.dylan_park.wordie.data.Dictionary;
import com.dylan_park.wordie.game.web.WebGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebGameController {

    @RequestMapping(value = "")
    public String wordie(Model model) {
        Dictionary dictionary = new Dictionary("src/main/resources/dictionary.txt");
        Dictionary bank = new Dictionary("src/main/resources/bank.txt");
        WebGame webGame = new WebGame(dictionary, bank);
        for (int i = 0; i < webGame.getWord().getWordArray().length; i++) {
            model.addAttribute("letter" + i, webGame.getWord().getWordArray()[i]);
        }
        return "webGame";
    }
}
