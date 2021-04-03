package at.george.wordcount;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class CLICallArgumentsTest {

    @Test
    public void verifyFromArgsIndexDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{"-index"});
        assertTrue(callArgs.isIndex());
        assertEquals(Optional.empty(), callArgs.getInputFile());
    }

    @Test
    public void verifyFromArgsFileDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{"othertext.txt"});
        assertFalse(callArgs.isIndex());
        assertEquals(Optional.of("othertext.txt"), callArgs.getInputFile());
    }

    @Test
    public void verifyEmptyFromArgsDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{});
        assertFalse(callArgs.isIndex());
        assertEquals(Optional.empty(), callArgs.getInputFile());
    }

    @Test
    public void verifyFromArgsOptionAndFileDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{"-index", "othertext.txt"});
        assertTrue(callArgs.isIndex());
        assertEquals(Optional.of("othertext.txt"), callArgs.getInputFile());
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyFromArgsMultipleNonOptionArgsDetection() {
        CLICallArguments.fromArgs(new String[]{"othertext.txt", "lorem.txt"});
    }
}