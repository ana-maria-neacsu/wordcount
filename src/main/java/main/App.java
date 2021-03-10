package main;

import io.ConsoleInputReader;
import io.FileInputReader;
import io.IOutils;
import io.InputReader;
import service.WordCountService;

import java.util.List;

public class App {

    public static void main(String[] args) {
        InputReader inputReader;
        if(args.length == 0)
            inputReader = new ConsoleInputReader();
        else
            inputReader = new FileInputReader(args[0]);

        String text = inputReader.readInput();

        IOutils iOutils = new IOutils();
        WordCountService wordCountService = new WordCountService();

        List<String> stopwords = iOutils.readStopWords();
        System.out.println(wordCountService.countWords(text, stopwords));
    }
}
