package wordcount.counters;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UniqueCounterTest {

    UniqueCounter counter = new UniqueCounter();

    @Test
    public void testCountWithEmptyString() {
        List<String> input = Arrays.asList("", "abc", "abcDe", "XXW");

        int count = counter.countWords(input);

        assert count == 3;
    }

    @Test
    public void testCountWithEmptyInput() {
        List<String> input = new LinkedList<>();

        int count = counter.countWords(input);

        assert count == 0;
    }

    @Test
    public void testCountWithDuplicates() {
        List<String> input = Arrays.asList("Humpty", "Dumpty", "sat", "on", "a", "wall", "Humpty", "Dumpty", "had", "a", "great", "fall");

        int count = counter.countWords(input);

        assert count == 9;
    }

    @Test
    public void testCountWithDuplicatesAndEmptyString() {
        List<String> input = Arrays.asList("", "Humpty", "Dumpty", "sat", "on", "a", "wall", "Humpty", "Dumpty", "had", "a", "great", "fall", "", "");

        int count = counter.countWords(input);

        assert count == 9;
    }
}
