package at.george.hiring.wordcount;

import java.util.Scanner;

public class WordCountApplication {

    private void run() {
        System.out.print("Enter text: ");
        try (Scanner input = new Scanner(System.in)) {
            String sentence = input.nextLine();
            int wordcount = 0;
            if (!sentence.trim().isEmpty()) {
                String[] words = sentence.trim().split("\\s+");
                for (String word : words) {
                    if (word.matches("[A-Za-z]+")) {
                        wordcount++;
                    }
                }
            }
            System.out.printf("Number of words: %d", wordcount);
        }
    }

    public static void main(String[] args) {
        new WordCountApplication().run();
    }
}
