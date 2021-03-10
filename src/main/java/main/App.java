package main;

import io.ConsoleInputReader;
import io.InputReader;
import service.WordCountService;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        WordCountService wordCountService = new WordCountService();

        String text = inputReader.readInput();
        System.out.println(wordCountService.countWords(text));
    }
}
