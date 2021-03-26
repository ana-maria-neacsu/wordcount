package at.george.hiring.wordcount;

import java.util.Scanner;

public class WordCountApplication {

    private void run() {
        System.out.print("Enter text: ");
        try (Scanner input = new Scanner(System.in)) {
            String sentence = input.nextLine();
            int wordcount = (sentence.trim().isEmpty()) ? 0 : sentence.trim().split("\\s+").length;
            System.out.printf("Number of words: %d", wordcount);
        }
    }

    public static void main(String[] args) {
        new WordCountApplication().run();
    }
}
