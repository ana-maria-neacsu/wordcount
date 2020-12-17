package wordcount.readers;

import wordcount.CountApp;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StopWordReader implements Reader {

    private InputStream stopWordStream;

    public StopWordReader(String fileName) {
        this.stopWordStream = CountApp.class.getClassLoader().getResourceAsStream(fileName);
    }

    public StopWordReader(InputStream inputStream) {
        this.stopWordStream = inputStream;
    }

    @Override
    public Set<String> read() {
        Set<String> stopWords = new HashSet<>();
        try (Scanner scanner = new Scanner(stopWordStream)) {
            while (scanner.hasNextLine()) {
                String stopWord = scanner.nextLine();
                if (stopWord.matches("[a-zA-Z]+")) {
                    stopWords.add(stopWord);
                }
            }
            return stopWords;
        }
    }
}
