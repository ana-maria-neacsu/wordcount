package at.george.wordcount;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

import static org.junit.Assert.*;

public class CLIApplicationTest {

    private final CLIApplication cliApplication = new CLIApplication();

    @Test
    public void verifyReadFromUser() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream captureOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captureOut));
            InputStream mockedInput = new ByteArrayInputStream("Mary had a little lamb".getBytes(Charset.defaultCharset()));
            System.setIn(mockedInput);
            cliApplication.readFromUser();

            assertEquals("Enter text: Number of words: 5", new String(captureOut.toByteArray(), Charset.defaultCharset()).trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

}