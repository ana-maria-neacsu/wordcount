package at.george.hiring.wordcount;

import at.george.hiring.wordcount.business.stopword.StopWordsClasspathLoaderImpl;
import at.george.hiring.wordcount.business.stopword.StopWordsLoader;
import at.george.hiring.wordcount.business.wordcount.WordCounter;
import at.george.hiring.wordcount.business.wordcount.WordCounterImpl;
import at.george.hiring.wordcount.input.ConsoleInputSourceImpl;
import at.george.hiring.wordcount.input.FileInputSourceImpl;
import at.george.hiring.wordcount.input.InputSource;
import at.george.hiring.wordcount.output.ConsoleSinkImpl;
import at.george.hiring.wordcount.output.OutputSink;

public class WordCountApplication {

    private final InputSource inputSource;
    private final OutputSink outputSink;
    private final WordCounter wordCounter;

    public WordCountApplication(InputSource inputSource, OutputSink outputSink, WordCounter wordCounter) {
        this.inputSource = inputSource;
        this.outputSink = outputSink;
        this.wordCounter = wordCounter;
    }

    public void run() {
        outputSink.print("Enter text: ");
        String sentence = inputSource.getText();
        long wordcount = wordCounter.countWords(sentence);
        outputSink.print(String.format("Number of words: %d", wordcount));
    }

    private static InputSource getInputSourceImplementation(String[] args) {
        if (args.length == 0) {
            return new ConsoleInputSourceImpl();
        } else {
            return new FileInputSourceImpl(args[0].trim());
        }
    }

    public static void main(String[] args) {
        InputSource inputSource = getInputSourceImplementation(args);
        OutputSink outputSink = new ConsoleSinkImpl();
        StopWordsLoader stopWordsLoader = new StopWordsClasspathLoaderImpl();
        WordCounter wordCounter = new WordCounterImpl(stopWordsLoader);
        new WordCountApplication(inputSource, outputSink, wordCounter).run();
    }
}
