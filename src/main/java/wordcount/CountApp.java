package wordcount;

import wordcount.counters.Counter;
import wordcount.counters.StopWordCounter;
import wordcount.readers.Reader;
import wordcount.readers.StopWordReader;
import wordcount.readers.WordReader;

import java.io.*;
import java.util.*;

public class CountApp {

    private Reader reader;
    private Counter counter;

    public CountApp(Reader reader, Counter counter) {
        this.reader = reader;
        this.counter = counter;
    }

    public int count() {
        Collection<String> words = reader.read();

        return counter.countWords(words);
    }

    public static void main(String[] args) throws IOException {
        CountApp countApp;

        if (args.length != 0) {
            countApp = new CountApp(new WordReader(new FileInputStream(new File(args[0]))), new StopWordCounter(new StopWordReader("stopwords.txt")));
        } else {
            System.out.println("Enter text:");
            countApp = new CountApp(new WordReader(System.in), new StopWordCounter(new StopWordReader("stopwords.txt")));
        }

        System.out.println("Number of words: " + countApp.count());
    }
}