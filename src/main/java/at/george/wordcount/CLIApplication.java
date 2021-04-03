package at.george.wordcount;

import java.util.Scanner;

public class CLIApplication {
    public static void main(String[] args) {
        new CLIApplication().readFromUser();
    }

    public void readFromUser() {
        WordCountService wordCounter = new WordCountService();
        System.out.print("Enter text: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String text = scanner.nextLine();
            long numWords = wordCounter.countWords(text);
            System.out.println("Number of words: " + numWords);
        }
    }
}
