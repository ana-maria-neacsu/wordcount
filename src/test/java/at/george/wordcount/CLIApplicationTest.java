package at.george.wordcount;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CLIApplicationTest {

    @Test
    public void verifyReadFromUser() {
        InputStream originalIn = System.in;
        try {
            InputStream mockedInput = new ByteArrayInputStream("Mary had a little lamb".getBytes(Charset.defaultCharset()));
            System.setIn(mockedInput);
            WordCountResult wordCountResult = new CLIApplication().readFromUser();
            assertEquals(4, wordCountResult.getNumWords());
            assertEquals(4, wordCountResult.getNumUniqueWords());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void verifyReadFromUserWithAlternativeStopwords() {
        InputStream originalIn = System.in;
        try {
            InputStream mockedInput = new ByteArrayInputStream("Mary had a little lamb".getBytes(Charset.defaultCharset()));
            System.setIn(mockedInput);
            WordCountResult wordCountResult = new CLIApplication(new AlternativeResourceProvider()).readFromUser();
            assertEquals(2, wordCountResult.getNumWords());
            assertEquals(2, wordCountResult.getNumUniqueWords());
        } finally {
            System.setIn(originalIn);
        }
    }
}

class AlternativeResourceProvider extends ResourceProvider {
    @Override
    public Set<String> fetchStopWords() {
        return new HashSet<>(Arrays.asList("Mary", "little", "lamb"));
    }
}