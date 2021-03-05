package at.erste;

import at.erste.words.input.InputReader;
import at.erste.words.input.InputReaderFromFile;
import at.erste.words.input.InputReaderFromStdIn;
import at.erste.words.stopwords.StopWords;
import at.erste.words.stopwords.StopWordsImpl;
import at.erste.words.WordCounter;

import java.util.Optional;

public class WordCounterApplication {

    public static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        System.out.print("Enter text: ");

        InputReader inputReader = getInputReader(args);
        StopWords stopWords = new StopWordsImpl(STOP_WORDS_FILE_NAME);
        WordCounter wordCounter = new WordCounter(Optional.of(stopWords));
        int numberOfWords = wordCounter.count(inputReader.getInput());

        System.out.println("Number of words: " + numberOfWords);
    }

    private static InputReader getInputReader(String[] args) {
        return args.length == 1 ?
                new InputReaderFromFile(args[0])
                :
                new InputReaderFromStdIn();
    }

}
