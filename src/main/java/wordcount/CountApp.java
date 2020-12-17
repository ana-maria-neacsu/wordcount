package wordcount;

import wordcount.counters.Counter;
import wordcount.counters.StopWordCounter;
import wordcount.counters.UniqueCounter;
import wordcount.readers.Reader;
import wordcount.readers.StopWordReader;
import wordcount.readers.WordReader;

import java.io.*;
import java.util.*;

public class CountApp {

    private Counter counter;
    private UniqueCounter uniqueCounter;
    private Collection<String> words;

    public CountApp(Reader reader, Counter counter, UniqueCounter uniqueCounter) {
        this.counter = counter;
        this.uniqueCounter = uniqueCounter;
        words = reader.read();
    }

    public int count() {
        return counter.countWords(words);
    }

    public int countUnique() {
        return uniqueCounter.countWords(words);
    }

    public static void main(String[] args) throws IOException {
        CountApp countApp;

        if (args.length != 0) {
            countApp = new CountApp(
                new WordReader(new FileInputStream(new File(args[0]))),
                new StopWordCounter(new StopWordReader("stopwords.txt")),
                new UniqueCounter()
            );
        } else {
            System.out.println("Enter text:");
            countApp = new CountApp(
                new WordReader(System.in),
                new StopWordCounter(new StopWordReader("stopwords.txt")),
                new UniqueCounter()
            );
        }

        System.out.println("Number of words: " + countApp.count() + ", unique: " + countApp.countUnique());
    }
}