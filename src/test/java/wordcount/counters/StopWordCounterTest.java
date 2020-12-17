package wordcount.counters;

import org.junit.Test;

import java.util.*;

public class StopWordCounterTest {

    @Test
    public void testEmptyStopWordsWithEmptyString() {
        StopWordCounter wordCounter = new StopWordCounter(Collections.emptySet());
        List<String> input = Arrays.asList("", "abc", "abcDe", "XXW");

        int count = wordCounter.countWords(input);

        assert count == 3;
    }

    @Test
    public void testEmptyStopWordsWithEmptyInput() {
        StopWordCounter wordCounter = new StopWordCounter(Collections.emptySet());
        List<String> input = Collections.emptyList();

        int count = wordCounter.countWords(input);

        assert count == 0;
    }

    @Test
    public void testStopWordsWithInput() {
        Collection<String> stopWords = Arrays.asList("abc", "abcDe", "XX");
        StopWordCounter wordCounter = new StopWordCounter(stopWords);
        List<String> input = Arrays.asList("", "abc", "abcDe", "XXW");

        int count = wordCounter.countWords(input);

        assert count == 1;
    }

    @Test
    public void testStopWordsWithEmptyInput() {
        Collection<String> stopWords = Arrays.asList("abc", "abcDe");
        StopWordCounter wordCounter = new StopWordCounter(stopWords);
        List<String> input = Collections.emptyList();

        int count = wordCounter.countWords(input);

        assert count == 0;
    }


    @Test
    public void testExampleStopWordsAndInput() {
        Collection<String> stopWords = Arrays.asList("the", "a", "on", "off");
        StopWordCounter wordCounter = new StopWordCounter(stopWords);
        List<String> input = Arrays.asList("Mary", "had", "a", "little", "lamb");

        int count = wordCounter.countWords(input);

        assert count == 4;
    }
}
