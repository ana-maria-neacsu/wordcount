package at.george.wordcount;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class WordCountServiceTest {

    private WordCountService wordCounter;

    @Before
    public void setup() {
        wordCounter = new WordCountService(new HashSet<>());
    }

    @Test
    public void verifyCountWordsBehaviour() {
        assertEquals(5, wordCounter.countWords("Mary had a little lamb").getNumWords());
        assertEquals(1, wordCounter.countWords("This").getNumWords());
        assertEquals(4, wordCounter.countWords("Tabs\tare\talso\tcounted").getNumWords());
        assertEquals(3, wordCounter.countWords("So\tare\nnewlines").getNumWords());
        assertEquals(5, wordCounter.countWords("Also € signs are no words $").getNumWords());
        assertEquals(2, wordCounter.countWords("word?, $right").getNumWords());
        assertEquals(0, wordCounter.countWords("$%823, 00990").getNumWords());
        assertEquals(4, wordCounter.countWords("This is awesome - right?").getNumWords());
    }

    @Test
    public void verifyThatNullArgumentDoesReturnZero() {
        assertEquals(0, wordCounter.countWords((String) null).getNumWords());
    }

    @Test
    public void verifyThatEmptyTextDoesReturnZero() {
        assertEquals(0, wordCounter.countWords("").getNumWords());
    }

    @Test
    public void verifyLeadingAndTrailingWhitespaceBehaviour() {
        assertEquals(5, wordCounter.countWords("  Mary had a little lamb").getNumWords());
        assertEquals(5, wordCounter.countWords("Mary had a little lamb  ").getNumWords());
        assertEquals(4, wordCounter.countWords("\tTabs\tare\talso\tcounted").getNumWords());
        assertEquals(4, wordCounter.countWords("Tabs\tare\talso\tcounted\t").getNumWords());
        assertEquals(3, wordCounter.countWords("\nSo\tare\nnewlines").getNumWords());
        assertEquals(3, wordCounter.countWords("So\tare\nnewlines\n").getNumWords());
        assertEquals(3, wordCounter.countWords("So\tare\nnewlines\n\t ").getNumWords());
    }

    @Test
    public void verifyStopwordsExclusionsBehaviour() {
        wordCounter = new WordCountService(new HashSet<>(Arrays.asList("this", "that")));
        assertEquals(3, wordCounter.countWords("this is awesome that this works!").getNumWords());

        wordCounter = new WordCountService(new HashSet<>(Arrays.asList("is", "and")));
        assertEquals(5, wordCounter.countWords("this is awesome that this works!").getNumWords());
    }

    @Test
    public void verifyUniqueWordCountBehaviour() {
        assertEquals(8, wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getNumUniqueWords());
        assertEquals(10, wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getNumWords());

        wordCounter = new WordCountService(new HashSet<>(Arrays.asList("a", "an")));
        assertEquals(7, wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getNumUniqueWords());
        assertEquals(8, wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getNumWords());
    }

    @Test
    public void verifyHyphenWordCountBehaviour() {
        assertEquals(1, wordCounter.countWords("Humpty-Dumpty").getNumWords());
        assertEquals(4, wordCounter.countWords("Humpty-Dumpty - what a name").getNumWords());
    }

    @Test
    public void verifyAvgWordLengthBehaviour() {
        assertEquals(BigDecimal.valueOf(51).divide(BigDecimal.valueOf(10), 2, RoundingMode.HALF_UP), wordCounter.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.").getAvgWordLength());
        assertEquals(BigDecimal.valueOf(49).divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP), wordCounter.countWords("Thisissuchalongword that Icannotbelieveitmakessense").getAvgWordLength());
    }
}