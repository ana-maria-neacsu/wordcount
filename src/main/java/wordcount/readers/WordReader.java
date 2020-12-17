package wordcount.readers;

import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordReader implements Reader {
    InputStream inputStream;

    public WordReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public Collection<String> read() {
        Scanner scanner = new Scanner(inputStream).useDelimiter("[^a-zA-Z]");
        List<String> words = new LinkedList<>();
        while (scanner.hasNext()) {
            String next = scanner.next();
            words.add(next);
        }
        return words;
    }
}
