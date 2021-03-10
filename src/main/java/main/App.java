package main;

import io.ConsoleInputReader;
import io.IOutils;
import io.InputReader;
import service.WordCountService;

import java.util.List;

public class App {

    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        IOutils iOutils = new IOutils();
        WordCountService wordCountService = new WordCountService();

        String text = inputReader.readInput();
        List<String> stopwords = iOutils.readStopWords();
        System.out.println(wordCountService.countWords(text, stopwords));
    }
}
