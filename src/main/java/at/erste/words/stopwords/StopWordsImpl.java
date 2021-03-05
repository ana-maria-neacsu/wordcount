package at.erste.words.stopwords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopWordsImpl implements StopWords {

    private final List<String> stopWords;

    public StopWordsImpl(final String stopWordsFileName) {
        stopWords = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(stopWordsFileName).getFile());

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                stopWords.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println(stopWordsFileName + "file does not exists. Exiting");
            System.exit(1);
        }
    }

    public List<String> getStopWords() {
        return stopWords;
    }
}
