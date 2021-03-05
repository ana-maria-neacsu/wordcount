package at.erste;

import at.erste.words.InputReader;
import at.erste.words.WordCounter;

public class Main {

    public static void main(String[] args) {

        System.out.print("Enter text: ");

        WordCounter wordCounter = new WordCounter();
        InputReader inputReader = new InputReader();
        int numberOfWords = wordCounter.count(inputReader.getInput());

        System.out.println("Number of words: " + numberOfWords);
    }
}
