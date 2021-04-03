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
    public void verifyMainCLIBehaviour() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        try {
            ByteArrayOutputStream captureOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(captureOut));
            InputStream mockedInput = new ByteArrayInputStream("I\tguess this is\tawesome! Right?\n ".getBytes(Charset.defaultCharset()));
            System.setIn(mockedInput);

            CLIApplication.main(new String[]{});

            assertEquals("Enter text: Number of words: 5", new String(captureOut.toByteArray(), Charset.defaultCharset()).trim());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
