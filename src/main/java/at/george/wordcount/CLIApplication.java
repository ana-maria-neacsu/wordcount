package at.george.wordcount;

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
        new CLIApplication().readFromUser();
    }

    public void readFromUser() {
        System.out.print("Enter text: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String text = scanner.nextLine();
            long numWords = wordCounter.countWords(text);
            System.out.println("Number of words: " + numWords);
        }
    }
}
