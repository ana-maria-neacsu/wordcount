import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordCountTest {
    WordCount wordCount = new WordCount();

    @Test
    public void testCountWithEmptyString() {
        List<String> input = Arrays.asList("", "abc", "abcDe", "XXW");

        int count = wordCount.countWords(input);

        assert count == 3;
    }

    @Test
    public void testCountWithEmptyArray() {
        List<String> input = new LinkedList<>();

        int count = wordCount.countWords(input);

        assert count == 0;
    }

}
