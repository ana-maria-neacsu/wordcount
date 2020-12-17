import wordcount.counters.Counter;
import wordcount.counters.StopWordCounter;
import wordcount.readers.Reader;
import wordcount.readers.SetReader;
import wordcount.readers.WordReader;

import java.io.InputStream;
import java.util.*;

public class CountApp {

    private Reader inputReader;
    private Counter counter;

    public CountApp(Reader inputReader, Counter counter) {
        this.inputReader = inputReader;
        this.counter = counter;
    }

    public int count(InputStream inputStream) {
        Collection<String> words = inputReader.read(inputStream);

        return counter.countWords(words);
    }

    public static void main(String[] args) {
        InputStream inputStream = CountApp.class.getClassLoader().getResourceAsStream("stopwords.txt");

        Reader stopWordsReader = new SetReader();

        CountApp countApp = new CountApp(new WordReader(), new StopWordCounter(stopWordsReader.read(inputStream)));

        System.out.println("Enter text:");
        System.out.println("Number of words: " + countApp.count(System.in));
    }
}