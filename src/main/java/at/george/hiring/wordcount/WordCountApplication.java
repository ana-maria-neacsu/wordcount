package at.george.hiring.wordcount;

import at.george.hiring.wordcount.business.WordCounter;
import at.george.hiring.wordcount.business.WordCounterImpl;
import at.george.hiring.wordcount.input.ConsoleInputSourceImpl;
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

    public static void main(String[] args) {
        InputSource inputSource = new ConsoleInputSourceImpl();
        OutputSink outputSink = new ConsoleSinkImpl();
        WordCounter wordCounter = new WordCounterImpl();
        new WordCountApplication(inputSource, outputSink, wordCounter).run();
    }
}
