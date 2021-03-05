package at.erste;

import at.erste.words.StandardInputReader;
import at.erste.words.StopWords;
import at.erste.words.WordCounter;

import java.io.FileNotFoundException;

public class Main {

    public static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) throws FileNotFoundException {

        System.out.print("Enter text: ");

        StopWords stopWords = new StopWords(STOP_WORDS_FILE_NAME);
        WordCounter wordCounter = new WordCounter(stopWords);
        StandardInputReader standardInputReader = new StandardInputReader();
        int numberOfWords = wordCounter.count(standardInputReader.getInput());

        System.out.println("Number of words: " + numberOfWords);
    }
}
