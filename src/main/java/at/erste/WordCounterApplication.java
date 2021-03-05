package at.erste;

import at.erste.words.input.InputReader;
import at.erste.words.input.InputReaderFromFile;
import at.erste.words.input.InputReaderFromStdIn;
import at.erste.words.ouput.WordCounterResult;
import at.erste.words.stopwords.StopWords;
import at.erste.words.stopwords.StopWordsImpl;
import at.erste.words.WordCounter;

import java.util.Optional;

import static java.lang.System.out;

public class WordCounterApplication {

    public static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        out.print("Enter text: ");

        InputReader inputReader = getInputReader(args);
        StopWords stopWords = new StopWordsImpl(STOP_WORDS_FILE_NAME);
        WordCounter wordCounter = new WordCounter(stopWords);
        WordCounterResult wordCounterResult = wordCounter.calculateResult(inputReader.getInput());
        wordCounterResult.printResult(out);
    }

    private static InputReader getInputReader(String[] args) {
        return args.length == 1 ?
                new InputReaderFromFile(args[0])
                :
                new InputReaderFromStdIn();
    }

}
