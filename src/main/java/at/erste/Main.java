package at.erste;

import at.erste.words.input.StandardInputReader;
import at.erste.words.stopwords.StopWords;
import at.erste.words.stopwords.StopWordsImpl;
import at.erste.words.WordCounter;

import java.io.FileNotFoundException;
import java.util.Optional;

public class Main {

    public static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {

        System.out.print("Enter text: ");

        StopWords stopWords = new StopWordsImpl(STOP_WORDS_FILE_NAME);
        WordCounter wordCounter = new WordCounter(Optional.of(stopWords));
        StandardInputReader standardInputReader = new StandardInputReader();
        int numberOfWords = wordCounter.count(standardInputReader.getInput());

        System.out.println("Number of words: " + numberOfWords);
    }
}
