package wordcount.readers;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StopWordReader implements Reader {
    @Override
    public Set<String> read(InputStream inputStream) {
        Set<String> stopWords = new HashSet<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String stopWord = scanner.nextLine();
            if (stopWord.matches("[a-zA-Z]+")) {
                stopWords.add(stopWord);
            }
        }
        return stopWords;
    }
}
