package at.george.wordcount;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class WordCountServiceTest {

    private WordCountService wordCounter;

    @Before
    public void setup() {
        wordCounter = new WordCountService(new HashSet<>());
    }

    @Test
    public void verifyCountWordsBehaviour() {
        assertEquals(5, wordCounter.countWords("Mary had a little lamb"));
        assertEquals(1, wordCounter.countWords("This"));
        assertEquals(4, wordCounter.countWords("Tabs\tare\talso\tcounted"));
        assertEquals(3, wordCounter.countWords("So\tare\nnewlines"));
        assertEquals(5, wordCounter.countWords("Also € signs are no words $"));
        assertEquals(2, wordCounter.countWords("word?, $right"));
        assertEquals(0, wordCounter.countWords("$%823, 00990"));
        assertEquals(4, wordCounter.countWords("This is awesome - right?"));
    }

    @Test
    public void verifyThatNullArgumentDoesReturnZero() {
        assertEquals(0, wordCounter.countWords((String)null));
    }

    @Test
    public void verifyThatEmptyTextDoesReturnZero() {
        assertEquals(0, wordCounter.countWords(""));
    }

    @Test
    public void verifyLeadingAndTrailingWhitespaceBehaviour() {
        assertEquals(5, wordCounter.countWords("  Mary had a little lamb"));
        assertEquals(5, wordCounter.countWords("Mary had a little lamb  "));
        assertEquals(4, wordCounter.countWords("\tTabs\tare\talso\tcounted"));
        assertEquals(4, wordCounter.countWords("Tabs\tare\talso\tcounted\t"));
        assertEquals(3, wordCounter.countWords("\nSo\tare\nnewlines"));
        assertEquals(3, wordCounter.countWords("So\tare\nnewlines\n"));
        assertEquals(3, wordCounter.countWords("So\tare\nnewlines\n\t "));
    }

    @Test
    public void verifyStopwordsExclusionsBehaviour() {
        wordCounter = new WordCountService(new HashSet<>(Arrays.asList("this", "that")));
        assertEquals(3, wordCounter.countWords("this is awesome that this works!"));

        wordCounter = new WordCountService(new HashSet<>(Arrays.asList("is", "and")));
        assertEquals(5, wordCounter.countWords("this is awesome that this works!"));
    }
}