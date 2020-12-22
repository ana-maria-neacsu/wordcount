import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {

    @Test
    public void countWordsWithNoStopWordsAndNoHyphensTest() {
        final Set<String> emptyStopWords = Collections.emptySet();

        Assert.assertEquals(4, WordCounter.countWords(Arrays.asList("Mary", "had", "a", "lamb"), emptyStopWords).getOverallCount());
        Assert.assertEquals(6,
                WordCounter.countWords(Arrays.asList("Mary", "had", "1", "lamb", "And", "Joe", "had", "2"), emptyStopWords).getOverallCount());
    }

    @Test
    public void countWordsWithNoStopWordsButWithWeirdSymbols() {
        final Set<String> emptyStopWords = Collections.emptySet();

        Assert.assertEquals(0, WordCounter.countWords(Collections.singletonList("H$ad"), emptyStopWords).getOverallCount());
        Assert.assertEquals(0, WordCounter.countWords(Collections.singletonList("541"), emptyStopWords).getOverallCount());
        Assert.assertEquals(2, WordCounter.countWords(Arrays.asList("Mary", "h$d", "&", "lamb"), emptyStopWords).getOverallCount());
    }

    @Test
    public void countWordsTestWithSomeStopWords() {
        final Set<String> stopWords = new HashSet<>(Arrays.asList("Mary", "LAMB"));
        Assert.assertEquals(2, WordCounter.countWords(Arrays.asList("Mary", "had", "a", "lamb"), stopWords).getOverallCount());
        Assert.assertEquals(0, WordCounter.countWords(Arrays.asList("Mary", "MARY", "mary", "LAMB", "lamb"), stopWords).getOverallCount());
        Assert.assertEquals(4, WordCounter.countWords(Arrays.asList("Joe", "had", "a", "sheep"), stopWords).getOverallCount());
    }

    @Test
    public void countWordsTestWithSomeStrangeStopWords() {
        final Set<String> multipleWordsInOneEntry = new HashSet<>(Collections.singletonList("Mary had a lamb"));
        Assert.assertEquals(4, WordCounter.countWords(Arrays.asList("Mary", "had", "a", "lamb"), multipleWordsInOneEntry).getOverallCount());

        final Set<String> strangeStopWords = new HashSet<>(Arrays.asList("-", "", "   ", " "));
        Assert.assertEquals(4, WordCounter.countWords(Arrays.asList("Mary", "had", "a", "lamb"), strangeStopWords).getOverallCount());
    }

    @Test
    public void countUniqWordsWithSomeStopWords() {
        final Set<String> stopWords = new HashSet<>(Arrays.asList("Mary", "LAMB"));
        Assert.assertEquals(0, WordCounter.countWords(Arrays.asList("Mary", "Mary", "mary"), stopWords).getUniqueCount());
        Assert.assertEquals(1, WordCounter.countWords(Arrays.asList("Joe", "Joe", "joe", "Lamb", "lamb"), stopWords).getUniqueCount());

        final Set<String> strangeStopWords = new HashSet<>(Collections.singletonList("Mary mary"));
        Assert.assertEquals(1, WordCounter.countWords(Arrays.asList("Mary", "Mary", "mary"), strangeStopWords).getUniqueCount());
    }

    @Test
    public void countUniqWordsNoStopWords() {
        final Set<String> emptyStopWords = Collections.emptySet();
        Assert.assertEquals(1, WordCounter.countWords(Arrays.asList("Mary", "Mary", "mary"), emptyStopWords).getUniqueCount());
        Assert.assertEquals(3, WordCounter.countWords(Arrays.asList("Mary", "had", "a", "mary"), emptyStopWords).getUniqueCount());
        Assert.assertEquals(3, WordCounter.countWords(Arrays.asList("Mary", "had", "had", "a", "mary"), emptyStopWords).getUniqueCount());
    }
}
