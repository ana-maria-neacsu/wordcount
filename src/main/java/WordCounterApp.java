import wordcounter.InputProvider;
import wordcounter.OutputConsole;
import wordcounter.WordCounter;

public class WordCounterApp {

    private final InputProvider inputProvider;
    private final OutputConsole console;

    public static void main(String[] args) {
        OutputConsole outputConsole = new OutputConsole();
        InputProvider inputProvider = new InputProvider();

        WordCounterApp wordCounterApp = new WordCounterApp(inputProvider, outputConsole);
        wordCounterApp.process();
    }

    public WordCounterApp(InputProvider inputProvider, OutputConsole console) {
        this.inputProvider = inputProvider;
        this.console = console;
    }

    public void process() {
        //get the input from the user
        console.printLine("Enter text: ");
        String inputText = inputProvider.getInput();

        //process the input
        WordCounter wordCounter = new WordCounter();
        int count = wordCounter.count(inputText);

        //print out the result
        console.printLine("Number of words: " + count);
    }


}
