package com.wordcounter.test;//package com.wordcounter.test;

import com.wordcounter.FileReader.impl.TextFileReaderImpl;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTests {

    @Test
    public void when_called_than_return_list_of_string() {
        String fileName = "stopwords.txt";
        URL fileUrl = FileReaderTests.class.getClassLoader().getResource(fileName);
        TextFileReaderImpl reader = new TextFileReaderImpl();
        reader.setup(fileUrl.getFile());
        List<String> lines = reader.readFile();

        assertEquals(4, lines.size());
    }
}
