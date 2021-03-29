import wordcounter.InputProvider;
import wordcounter.OutputConsole;
import wordcounter.StopWordsProvider;
import wordcounter.WordCounter;

public class WordCounterApp {

    private static final String STOP_WORDS_FILENAME = "stopwords.txt";

    private final InputProvider inputProvider;
    private final OutputConsole console;
    private final StopWordsProvider stopWordsProvider;

    public static void main(String[] args) {
        OutputConsole outputConsole = new OutputConsole();
        InputProvider inputProvider = new InputProvider();
        StopWordsProvider stopWordsProvider = new StopWordsProvider(STOP_WORDS_FILENAME);

        WordCounterApp wordCounterApp = new WordCounterApp(inputProvider, outputConsole, stopWordsProvider);
        wordCounterApp.process();
    }

    public WordCounterApp(InputProvider inputProvider, OutputConsole console, StopWordsProvider stopWordsProvider) {
        this.inputProvider = inputProvider;
        this.console = console;
        this.stopWordsProvider = stopWordsProvider;
    }

    public void process() {
        //get the input from the user
        console.printLine("Enter text: ");
        String inputText = inputProvider.getInput();

        //process the input
        WordCounter wordCounter = new WordCounter(inputText, stopWordsProvider.getStopWords());
        int count = wordCounter.count();

        //print out the result
        console.printLine("Number of words: " + count);
    }

}
