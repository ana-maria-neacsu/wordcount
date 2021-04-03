package at.george.wordcount;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

public class CLIApplicationIT {

    @Test
    public void verifyUserInputCLIBehaviour() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream captureOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captureOut));
            InputStream mockedInput = new ByteArrayInputStream("I\tguess this is\tawesome! Right?\n ".getBytes(Charset.defaultCharset()));
            System.setIn(mockedInput);

            CLIApplication.main(new String[]{});

            assertEquals("Enter text: Number of words: 5, unique: 5; average word length: 4.40 characters", new String(captureOut.toByteArray(), Charset.defaultCharset()).trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void verifyFileInputCLIBehaviour() {
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream captureOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captureOut));

            CLIApplication.main(new String[]{"mytext.txt"});

            assertEquals("Number of words: 4, unique: 4; average word length: 4.25 characters", new String(captureOut.toByteArray(), Charset.defaultCharset()).trim());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void verifyFileInputWithIndexOptionCLIBehaviour() {
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream captureOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captureOut));

            CLIApplication.main(new String[]{"-index", "mytext.txt"});

            assertEquals("Number of words: 4, unique: 4; average word length: 4.25 characters\nIndex:\nMary\nhad\nlamb\nlittle",
                    new String(captureOut.toByteArray(), Charset.defaultCharset()).trim().replace("\r", ""));
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyArgumentVerificationCLIBehaviour() {
        CLIApplication.main(new String[]{"mytext.txt", "doesnotwork!"});
    }
}
