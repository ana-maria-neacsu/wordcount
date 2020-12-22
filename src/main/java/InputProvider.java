import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InputProvider {

    private final InputReader inputReader;

    InputProvider(final InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public String getInput(final String[] args) throws FileNotFoundException {
        final String input;
        if (args.length > 0) {
            input = this.inputReader.readFile(args[0]);
        } else {
            System.out.print("Enter text: ");
            input = this.inputReader.readStandardInput();
        }

        return input;
    }

    public Set<String> getStopWords() {
        final String stopWords;
        try {
            stopWords = inputReader.readFile("stopwords.txt");
        } catch (final FileNotFoundException ex) {
            System.out.println("stopwords.txt file not found, defaulting to empty stop words.");
            return new HashSet<>();
        }

        final Set<String> stopWordsSet = new HashSet<>();
        Collections.addAll(stopWordsSet, stopWords.split("\n"));

        return stopWordsSet;
    }
}
