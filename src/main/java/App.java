import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class App {

    private final InputReader inputReader;

    App(final InputReader inputReader) {
        this.inputReader = inputReader;
    }

    int count(final String[] args) throws FileNotFoundException {
        return this.countWords(this.getInput(args), this.getStopWords());
    }

    String getInput(final String[] args) throws FileNotFoundException {
        final String input;
        if (args.length > 0) {
            input = this.inputReader.readFile(args[0]);
        } else {
            System.out.print("Enter text: ");
            input = this.inputReader.readStandardInput();
        }

        return input;
    }

    Set<String> getStopWords() {
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

    int countWords(final String input, final Set<String> stopWords) {
        final String[] possibleWords = input.split(",|\\.|\\s+");

        // just in case convert all stop words into the lowercase - the match should be case insensitive
        final Set<String> loverCaseStopWords = stopWords.stream().map(String::toLowerCase).collect(Collectors.toSet());

        int countOfActualWords = 0;
        for (final String possibleWord: possibleWords) {
            // convert to lowercase, so we can more easily check if the word is actual word and if it is not in stop
            // words, these should be already lowercase
            final String lowerCaseWord = possibleWord.toLowerCase();
            if (lowerCaseWord.matches("[a-z-]+") && !loverCaseStopWords.contains(lowerCaseWord)) {
                countOfActualWords++;
            }
        }

        return countOfActualWords;
    }
}
