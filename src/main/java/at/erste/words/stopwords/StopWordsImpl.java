package at.erste.words.stopwords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StopWordsImpl implements StopWords {

    public static final String STOP_WORDS_FILE_NAME = "stopwords.txt";
    private final Set<String> stopWords;

    public StopWordsImpl(final String stopWordsFileName) {
        stopWords = new HashSet<>();
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

    public Set<String> getStopWords() {
        return stopWords;
    }
}
