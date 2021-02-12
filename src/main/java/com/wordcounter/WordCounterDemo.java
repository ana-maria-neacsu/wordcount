package com.wordcounter;

import com.wordcounter.FileReader.FileReader;
import com.wordcounter.FileReader.impl.TextFileReaderImpl;
import com.wordcounter.StopWordsReader.StopWordsReader;
import com.wordcounter.StopWordsReader.impl.StopWordsReaderImpl;
import com.wordcounter.TextParser.TextParser;
import com.wordcounter.TextParser.impl.TextParserImpl;
import com.wordcounter.TextReader.TextReader;
import com.wordcounter.TextReader.impl.ConsoleTextReaderImpl;

import java.net.URL;

public class WordCounterDemo {

    public static void main(String[] args) {

        TextReader reader = new ConsoleTextReaderImpl();
        String text = reader.readText();

        TextParser textParser = new TextParserImpl(" ");
        FileReader textFileReader = new TextFileReaderImpl();

        String stopFilesName = "";
        URL fileUrl = WordCounterDemo.class.getClassLoader().getResource(stopFilesName);
        StopWordsReader stopWordsReader = new StopWordsReaderImpl(textFileReader, fileUrl.getFile());

        WordCounter wordCounter = new WordCounter(text, textParser, stopWordsReader);
        Long wordNumber = wordCounter.countWords();

        System.out.print(wordNumber);
    }
}
