package wordcount;

import wordcount.counters.Counter;
import wordcount.counters.StopWordCounter;
import wordcount.readers.Reader;
import wordcount.readers.StopWordReader;
import wordcount.readers.WordReader;

import java.io.InputStream;
import java.util.*;

public class CountApp {

    private Reader reader;
    private Counter counter;

    public CountApp(Reader reader, Counter counter) {
        this.reader = reader;
        this.counter = counter;
    }

    public int count(InputStream inputStream) {
        Collection<String> words = reader.read(inputStream);

        return counter.countWords(words);
    }

    public static void main(String[] args) {
        InputStream inputStream = CountApp.class.getClassLoader().getResourceAsStream("stopwords.txt");

        Reader stopWordsReader = new StopWordReader();

        CountApp countApp = new CountApp(new WordReader(), new StopWordCounter(stopWordsReader.read(inputStream)));

        System.out.println("Enter text:");
        System.out.println("Number of words: " + countApp.count(System.in));
    }
}