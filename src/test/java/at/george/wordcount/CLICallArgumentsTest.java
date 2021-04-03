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
        assertEquals(Optional.empty(), callArgs.getDictionary());
    }

    @Test
    public void verifyFromArgsFileDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{"othertext.txt"});
        assertFalse(callArgs.isIndex());
        assertEquals(Optional.of("othertext.txt"), callArgs.getInputFile());
        assertEquals(Optional.empty(), callArgs.getDictionary());
    }

    @Test
    public void verifyEmptyFromArgsDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{});
        assertFalse(callArgs.isIndex());
        assertEquals(Optional.empty(), callArgs.getInputFile());
        assertEquals(Optional.empty(), callArgs.getDictionary());
    }

    @Test
    public void verifyFromArgsAllFieldsDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{"-index", "othertext.txt", "-dictionary=dict.txt"});
        assertTrue(callArgs.isIndex());
        assertEquals(Optional.of("othertext.txt"), callArgs.getInputFile());
        assertEquals(Optional.of("dict.txt"), callArgs.getDictionary());
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyFromArgsMultipleNonOptionArgsDetection() {
        CLICallArguments.fromArgs(new String[]{"othertext.txt", "lorem.txt"});
    }

    @Test
    public void verifyDictionaryArgDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{"-dictionary=dict.txt"});
        assertFalse(callArgs.isIndex());
        assertEquals(Optional.empty(), callArgs.getInputFile());
        assertEquals(Optional.of("dict.txt"), callArgs.getDictionary());
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyMultipleDictionaryArgDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{"-dictionary=dict.txt", "-dictionary=dict2.txt"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyDictionaryArgNotEmptyDetection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{"-dictionary="});
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyDictionaryArgNotEmpty2Detection() {
        CLICallArguments callArgs = CLICallArguments.fromArgs(new String[]{"-dictionary"});
    }
}