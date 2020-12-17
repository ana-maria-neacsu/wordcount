package wordcount.readers;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetReader implements Reader {
    @Override
    public Collection<String> read(InputStream inputStream) {
        Set<String> stopWords = new HashSet<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String stopWord = scanner.nextLine();
            stopWords.add(stopWord);
        }
        return stopWords;
    }
}
