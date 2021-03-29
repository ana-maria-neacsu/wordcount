import java.util.Collections;
import java.util.Set;
import wordcounter.InputProvider;
import wordcounter.OutputConsole;
import wordcounter.WordCounter;

public class WordCounterApp {

    private final InputProvider inputProvider;
    private final OutputConsole console;
    private final Set<String> stopWords;

    public static void main(String[] args) {
        OutputConsole outputConsole = new OutputConsole();
        InputProvider inputProvider = new InputProvider();

        WordCounterApp wordCounterApp = new WordCounterApp(inputProvider, outputConsole, Collections.emptySet());
        wordCounterApp.process();
    }

    public WordCounterApp(InputProvider inputProvider, OutputConsole console, Set<String> stopWords) {
        this.inputProvider = inputProvider;
        this.console = console;
        this.stopWords = stopWords;
    }

    public void process() {
        //get the input from the user
        console.printLine("Enter text: ");
        String inputText = inputProvider.getInput();

        //process the input
        WordCounter wordCounter = new WordCounter(inputText, stopWords);
        int count = wordCounter.count();

        //print out the result
        console.printLine("Number of words: " + count);
    }


}
