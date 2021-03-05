package at.erste;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter text: ");

        WordCounter wordCounter = new WordCounter();
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {

                int numberOfWords = wordCounter.count(scanner.nextLine());
                System.out.println("Number of words: " + numberOfWords);
            }
        }

    }
}
