package at.george.wordcount;

import java.util.List;
import java.util.Scanner;

public class CLIApplication {
    private final ResourceProvider resourceProvider;
    private final WordCountService wordCounter;

    public CLIApplication() {
        this(new ResourceProvider());
    }

    public CLIApplication(ResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
        this.wordCounter = new WordCountService(this.resourceProvider.fetchStopWords());
    }

    public static void main(String[] args) {
        CLICallArguments callArgs = CLICallArguments.fromArgs(args);
        CLIApplication cliApplication = new CLIApplication();

        WordCountResult wordCountResult;
        if (!callArgs.getInputFile().isPresent()) {
            wordCountResult = cliApplication.readFromUser();
        } else {
            wordCountResult = cliApplication.readFromFile(callArgs.getInputFile().get());
        }

        System.out.println("Number of words: " + wordCountResult.getNumWords() +
                ", unique: " + wordCountResult.getNumUniqueWords() + "; " +
                "average word length: " + wordCountResult.getAvgWordLength() + " characters");

        if (callArgs.isIndex()) {
            System.out.println("Index:");
            wordCountResult.getSortedWords().forEach(System.out::println);
        }
    }

    private WordCountResult readFromFile(String filename) {
        List<String> words;
        try {
            words = this.resourceProvider.fetchFromFile(filename);
        } catch (ResourceProvider.ResourceNotFoundException iae) {
            words = this.resourceProvider.fetchFromFile("/" + filename);
        }
        return wordCounter.countWords(words.stream());
    }

    public WordCountResult readFromUser() {
        System.out.print("Enter text: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String text = scanner.nextLine();
            return wordCounter.countWords(text);
        }
    }
}
