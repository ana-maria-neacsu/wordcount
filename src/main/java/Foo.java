import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Foo {

    public static void main(final String[] args) {
        System.out.print("Enter text: ");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        System.out.println("Number of words: " + countWords(input, getStopWords()));
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

    static int countWords(final String line, final Set<String> stopWords) {
        final String[] possibleWords = line.split(",|\\.|\\s+");

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
