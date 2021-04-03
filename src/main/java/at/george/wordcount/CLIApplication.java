package at.george.wordcount;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class CLIApplication {
    private final ResourceProvider resourceProvider;
    private final WordCountService wordCounter;

    public CLIApplication() {
        this(new ResourceProvider(), Optional.empty());
    }

    public CLIApplication(ResourceProvider resourceProvider) {
        this(resourceProvider, Optional.empty());
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public CLIApplication(ResourceProvider resourceProvider, Optional<String> dictionaryPath) {
        this.resourceProvider = resourceProvider;
        this.wordCounter = dictionaryPath
                .map(s -> new WordCountService(this.resourceProvider.fetchStopWords(), fetchDictionary(s)))
                .orElseGet(() -> new WordCountService(this.resourceProvider.fetchStopWords()));
    }

    public static void main(String[] args) {
        CLICallArguments callArgs = CLICallArguments.fromArgs(args);
        CLIApplication cliApplication = new CLIApplication(new ResourceProvider(), callArgs.getDictionary());
        WordCountResult wordCountResult = getWordCountResult(callArgs, cliApplication);
        printWordCountResults(callArgs, wordCountResult);
    }

    private static void printWordCountResults(CLICallArguments callArgs, WordCountResult wordCountResult) {
        System.out.println("Number of words: " + wordCountResult.getNumWords() +
                ", unique: " + wordCountResult.getNumUniqueWords() + "; " +
                "average word length: " + wordCountResult.getAvgWordLength() + " characters");

        if (callArgs.isIndex()) {
            if (callArgs.getDictionary().isPresent()) {
                System.out.println("Index (unknown: " + wordCountResult.getNumUnknown() + "):");
            } else {
                System.out.println("Index:");
            }
            wordCountResult.getSortedWords().forEach(System.out::println);
        }
    }

    private static WordCountResult getWordCountResult(CLICallArguments callArgs, CLIApplication cliApplication) {
        WordCountResult wordCountResult;
        if (!callArgs.getInputFile().isPresent()) {
            wordCountResult = cliApplication.readFromUser();
        } else {
            wordCountResult = cliApplication.readFromFile(callArgs.getInputFile().get());
        }
        return wordCountResult;
    }

    protected WordCountResult readFromFile(String filename) {
        List<String> words;
        try {
            words = this.resourceProvider.fetchFromFile(filename);
        } catch (ResourceProvider.ResourceNotFoundException iae) {
            words = this.resourceProvider.fetchFromFile("/" + filename);
        }
        return wordCounter.countWords(words.stream());
    }

    protected WordCountResult readFromUser() {
        System.out.print("Enter text: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String text = scanner.nextLine();
            return wordCounter.countWords(text);
        }
    }

    protected Set<String> fetchDictionary(String dictionaryPath) {
        try {
            return this.resourceProvider.fetchDictionary(dictionaryPath);
        } catch (ResourceProvider.ResourceNotFoundException iae) {
            return this.resourceProvider.fetchDictionary("/" + dictionaryPath);
        }
    }
}
