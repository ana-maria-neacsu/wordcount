package at.george.hiring.wordcount;

import at.george.hiring.wordcount.business.stopword.StopWordsClasspathLoaderImpl;
import at.george.hiring.wordcount.business.stopword.StopWordsLoader;
import at.george.hiring.wordcount.business.wordcount.WordCountData;
import at.george.hiring.wordcount.business.wordcount.WordCounter;
import at.george.hiring.wordcount.business.wordcount.WordCounterImpl;
import at.george.hiring.wordcount.input.InputSource;
import at.george.hiring.wordcount.input.InputSourceFactory;
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

    public void run(String[] args) {
        outputSink.print("Enter text: ");
        String sentence = inputSource.getText();
        WordCountData wordCountData = wordCounter.countWords(sentence);
        outputSink.print(
                String.format("Number of words: %d, unique: %d, average word length: %.2f",
                        wordCountData.getWordCount(),
                        wordCountData.getUniqueWords(),
                        wordCountData.getAverageWordLength()
                )
        );

        // TODO Redo this, don't check for "-index" here
        if (args.length > 0 && args[0].startsWith("-index")) {
            outputSink.print("\nIndex:\n");
            wordCountData.getUniqueWordSet().forEach(w -> outputSink.print(w + "\n"));
        }
    }

    public static void main(String[] args) {
        InputSource inputSource = InputSourceFactory.newInstance(args);
        OutputSink outputSink = new ConsoleSinkImpl();
        StopWordsLoader stopWordsLoader = new StopWordsClasspathLoaderImpl();
        WordCounter wordCounter = new WordCounterImpl(stopWordsLoader);
        new WordCountApplication(inputSource, outputSink, wordCounter).run(args);
    }
}
