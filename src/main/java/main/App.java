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
        boolean indexFlag = false;
        if(args.length == 0)
            inputReader = new ConsoleInputReader();
        else {
            if(!args[0].startsWith("-")) {
                inputReader = new FileInputReader(args[0]);
            } else {
                inputReader = new ConsoleInputReader();
                indexFlag = true;
            }
        }

        String text = inputReader.readInput();

        IOutils iOutils = new IOutils();
        WordCountService wordCountService = new WordCountService();

        List<String> stopwords = iOutils.readStopWords();
        System.out.println(IOutils.createOutput(wordCountService.countWords(text, stopwords),
                wordCountService.countUniqueWords(text,stopwords),
                wordCountService.averageWordsLength(text,stopwords),
                wordCountService.indexOfText(text,stopwords), indexFlag
                ));
    }
}
