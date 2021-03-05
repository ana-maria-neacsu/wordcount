package at.erste.words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopWords {

    private List<String> stopWords;

    public StopWords(final String stopWordsFileName) throws FileNotFoundException {
        //TODO remove exception
        stopWords = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(stopWordsFileName).getFile());

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                stopWords.add(sc.nextLine());
            }
        }
    }

    public List<String> getStopWords() {
        return stopWords;
    }
}
