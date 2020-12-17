package wordcount.counters;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StopWordCounterUniqueTest {

    @Test
    public void testCountWithEmptyString() {
        StopWordCounter counter = new StopWordCounter(Collections.emptySet());
        List<String> input = Arrays.asList("", "abc", "abcDe", "XXW");

        int count = counter.countUniques(input);

        assert count == 3;
    }

    @Test
    public void testCountWithEmptyInput() {
        StopWordCounter counter = new StopWordCounter(Collections.emptySet());
        List<String> input = new LinkedList<>();

        int count = counter.countUniques(input);

        assert count == 0;
    }

    @Test
    public void testCountWithDuplicates() {
        StopWordCounter counter = new StopWordCounter(Collections.emptySet());
        List<String> input = Arrays.asList("Humpty", "Dumpty", "sat", "on", "a", "wall", "Humpty", "Dumpty", "had", "a", "great", "fall");

        int count = counter.countUniques(input);

        assert count == 9;
    }

    @Test
    public void testCountWithDuplicatesAndEmptyString() {
        StopWordCounter counter = new StopWordCounter(Collections.emptySet());
        List<String> input = Arrays.asList("", "Humpty", "Dumpty", "sat", "on", "a", "wall", "Humpty", "Dumpty", "had", "a", "great", "fall", "", "");

        int count = counter.countUniques(input);

        assert count == 9;
    }

    @Test
    public void testCountWithDuplicatesAndStopWords() {
        StopWordCounter counter = new StopWordCounter(Arrays.asList("the", "a", "on", "off"));
        List<String> input = Arrays.asList("", "Humpty", "Dumpty", "sat", "on", "a", "wall", "Humpty", "Dumpty", "had", "a", "great", "fall", "", "");

        int count = counter.countUniques(input);

        assert count == 7;
    }
}
