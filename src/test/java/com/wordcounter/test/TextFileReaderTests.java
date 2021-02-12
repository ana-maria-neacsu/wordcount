package com.wordcounter.test;

import com.wordcounter.FileReader.impl.TextFileReaderImpl;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextFileReaderTests {

    private static final String MISSING_MOCKED_STOPPED_FILE_NAME = "stopwords_missing.txt";
    private static final String MOCKED_STOPPED_FILE_NAME = "stopwords.txt";

    @Test
    public void when_called_on_existing_file_than_return_list_of_string() {
        URL fileUrl = TextFileReaderTests.class.getClassLoader().getResource(MOCKED_STOPPED_FILE_NAME);
        TextFileReaderImpl reader = new TextFileReaderImpl();
        List<String> lines = reader.readFile(fileUrl.getFile());

        assertEquals(4, lines.size());
    }

    @Test
    public void when_called_on_missing_file_than_return_emty_list() {
        TextFileReaderImpl reader = new TextFileReaderImpl();
        List<String> lines = reader.readFile(MISSING_MOCKED_STOPPED_FILE_NAME);

        assertEquals(0, lines.size());
    }
}
