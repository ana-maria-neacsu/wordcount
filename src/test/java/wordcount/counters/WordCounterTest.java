package wordcount.counters;

import org.junit.Test;
import wordcount.counters.WordCounter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordCounterTest {
    WordCounter wordCounter = new WordCounter();

    @Test
    public void testCountWithEmptyString() {
        List<String> input = Arrays.asList("", "abc", "abcDe", "XXW");

        int count = wordCounter.countWords(input);

        assert count == 3;
    }

    @Test
    public void testCountWithEmptyInput() {
        List<String> input = new LinkedList<>();

        int count = wordCounter.countWords(input);

        assert count == 0;
    }
}
