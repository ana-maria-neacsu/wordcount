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
        CLIApplication cliApplication = new CLIApplication();
        WordCountResult wordCountResult;
        if (args.length == 0) {
            wordCountResult = cliApplication.readFromUser();
        } else if (args.length == 1) {
            wordCountResult = cliApplication.readFromFile(args[0]);
        } else {
            throw new IllegalArgumentException("Please only supply at most 1 argument - the filename of the words!");
        }
        System.out.println("Number of words: " + wordCountResult.getNumWords() + ", unique: " + wordCountResult.getNumUniqueWords());
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
