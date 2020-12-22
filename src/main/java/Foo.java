import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Foo {

    public static void main(final String[] args) throws FileNotFoundException {
        System.out.println("Number of words: " + countWords(getInput(args), getStopWords()));
    }

    static String getInput(final String[] args) throws FileNotFoundException {
        final Scanner scanner;
        if (args.length > 0) {
            scanner = new Scanner(new File(args[0]));
        } else {
            System.out.print("Enter text: ");
            scanner = new Scanner(System.in);
        }

        final StringBuilder input = new StringBuilder();
        while (scanner.hasNextLine()) {
            input.append(scanner.nextLine()).append('\n');
        }

        return input.toString();
    }

    static Set<String> getStopWords() {
        final Scanner scanner;
        try {
            scanner = new Scanner(new File("stopwords.txt"));
        } catch (final FileNotFoundException ex) {
            System.out.println("stopwords.txt file not found, defaulting to empty stop words.");
            return new HashSet<>();
        }

        final Set<String> stopWords = new HashSet<>();
        while (scanner.hasNextLine()) {
            stopWords.add(scanner.nextLine().toLowerCase());
        }

        return stopWords;
    }

    static int countWords(final String input, final Set<String> stopWords) {
        final String[] possibleWords = input.split(",|\\.|\\s+");

        // just in case convert all stop words into the lowercase - the match should be case insensitive
        final Set<String> loverCaseStopWords = stopWords.stream().map(String::toLowerCase).collect(Collectors.toSet());

        int countOfActualWords = 0;
        for (final String possibleWord: possibleWords) {
            // convert to lowercase, so we can more easily check if the word is actual word and if it is not in stop
            // words, these should be already lowercase
            final String lowerCaseWord = possibleWord.toLowerCase();
            if (lowerCaseWord.matches("[a-z]+") && !loverCaseStopWords.contains(lowerCaseWord)) {
                countOfActualWords++;
            }
        }

        return countOfActualWords;
    }
}
