package com.wordcounter.test;//package com.wordcounter.test;

import com.wordcounter.FileReader.impl.TextFileReaderImpl;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextFileReaderTests {

    @Test
    public void when_called_on_existing_file_than_return_list_of_string() {
        String fileName = "stopwords.txt";
        URL fileUrl = TextFileReaderTests.class.getClassLoader().getResource(fileName);
        TextFileReaderImpl reader = new TextFileReaderImpl();
        List<String> lines = reader.readFile(fileUrl.getFile());

        assertEquals(4, lines.size());
    }

    @Test
    public void when_called_on_missing_file_than_return_emty_list() {
        String fileName = "stopwords_missing.txt";
        TextFileReaderImpl reader = new TextFileReaderImpl();
        List<String> lines = reader.readFile(fileName);

        assertEquals(0, lines.size());
    }
}
