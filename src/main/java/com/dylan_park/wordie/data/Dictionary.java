package com.dylan_park.wordie.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Dictionary {
    private final String pathString;
    private final ArrayList<String> dictionaryArray;

    public Dictionary(String pathString) {
        this.pathString = pathString;
        int size = (int) getTotalLineNumbers();
        this.dictionaryArray = new ArrayList<>(size);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(this.pathString));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            assert scanner != null;
            if (!scanner.hasNext()) break;
            dictionaryArray.add(scanner.next());
        }
        scanner.close();
    }

    public long getTotalLineNumbers() {
        Path path = Paths.get(pathString);
        long lines = 0;

        try {
            lines = Files.lines(path).parallel().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public String getWordFromLineNumber(long lineNumber) {
        try (Stream<String> lines = Files.lines(Paths.get(pathString))) {
            Optional<String> word = lines.skip(lineNumber - 1).findFirst();
            return word.orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getDictionaryArray() {
        return dictionaryArray;
    }
}
