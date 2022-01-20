package com.dylan_park.wordie.data;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Word {
    private final String wordString;
    private final String[] wordArray;
    private final int length;

    public Word(@NotNull String input) {
        length = input.length();
        wordString = input;
        wordArray = input.split("");
    }

    @Override
    public String toString() {
        return Arrays.toString(wordArray);
    }

    public String getWordString() {
        return wordString;
    }

    public String[] getWordArray() {
        return wordArray;
    }

    public int getLength() {
        return length;
    }
}
