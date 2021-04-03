package at.george.wordcount;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CLIApplicationTest {

    @Test
    public void verifyReadFromUser() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream captureOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captureOut));
            InputStream mockedInput = new ByteArrayInputStream("Mary had a little lamb".getBytes(Charset.defaultCharset()));
            System.setIn(mockedInput);
            new CLIApplication().readFromUser();

            assertEquals("Enter text: Number of words: 4", new String(captureOut.toByteArray(), Charset.defaultCharset()).trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void verifyReadFromUserWithAlternativeStopwords() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream captureOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captureOut));
            InputStream mockedInput = new ByteArrayInputStream("Mary had a little lamb".getBytes(Charset.defaultCharset()));
            System.setIn(mockedInput);
            new CLIApplication(new AlternativeResourceProvider()).readFromUser();

            assertEquals("Enter text: Number of words: 2", new String(captureOut.toByteArray(), Charset.defaultCharset()).trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}

class AlternativeResourceProvider extends ResourceProvider {
    @Override
    public Set<String> fetchStopWords() {
        return new HashSet<>(Arrays.asList("Mary", "little", "lamb"));
    }
}