package at.erste.words;

import at.erste.words.input.InputReader;
import at.erste.words.input.InputReaderFromFile;
import at.erste.words.input.InputReaderFromStdIn;
import at.erste.words.ouput.WordCounterResult;
import at.erste.words.stopwords.StopWords;
import at.erste.words.stopwords.StopWordsImpl;

import static at.erste.words.stopwords.StopWordsImpl.STOP_WORDS_FILE_NAME;
import static java.lang.System.out;

public class WordCounterApplication {

    public static void main(String[] args) {

        InputReader inputReader = getInputReader(args);
        StopWords stopWords = new StopWordsImpl(STOP_WORDS_FILE_NAME);
        WordCounter wordCounter = new WordCounter(stopWords);
        WordCounterResult wordCounterResult = wordCounter.calculateResult(inputReader.getInput());
        wordCounterResult.printResult(out);
    }

    private static InputReader getInputReader(String[] args) {
        if (args.length == 1) {
            return new InputReaderFromFile(args[0]);
        }
        return new InputReaderFromStdIn(out);
    }
}
