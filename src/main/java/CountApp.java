import wordcount.counters.Counter;
import wordcount.counters.WordCounter;
import wordcount.readers.Reader;
import wordcount.readers.WordReader;

import java.io.InputStream;
import java.util.List;

public class CountApp {

    private Reader wordReader;
    private Counter wordCounter;

    public CountApp(Reader reader, Counter counter) {
        wordReader = reader;
        wordCounter = counter;
    }

    public int count(InputStream inputStream) {
        List<String> words = wordReader.read(inputStream);

        return wordCounter.countWords(words);
    }

    public static void main(String[] args) {
        CountApp countApp = new CountApp(new WordReader(), new WordCounter());

        System.out.println("Enter text:");
        System.out.println("Number of words: " + countApp.count(System.in));
    }
}