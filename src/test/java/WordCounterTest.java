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
        Assert.assertEquals(4, WordCounter.countWords("Mary had a lamb", emptyStopWords).getOverallCount());
        Assert.assertEquals(4, WordCounter.countWords("Mary, had a lamb.", emptyStopWords).getOverallCount());
        Assert.assertEquals(1, WordCounter.countWords("Mary", emptyStopWords).getOverallCount());
        Assert.assertEquals(8, WordCounter.countWords("Mary had a lamb. And Joe had two.", emptyStopWords).getOverallCount());
        Assert.assertEquals(6, WordCounter.countWords("Mary had 1 lamb. And Joe had 2.", emptyStopWords).getOverallCount());
    }

    @Test
    public void countWordsWithNoStopWordsButWithHyphensTest() {
        final Set<String> emptyStopWords = Collections.emptySet();
        Assert.assertEquals(5, WordCounter.countWords("Mary-Jane had a lamb.", emptyStopWords).getOverallCount());
        Assert.assertEquals(7, WordCounter.countWords("Mary-Jane-Ashley had a lamb-horse.", emptyStopWords).getOverallCount());
        Assert.assertEquals(2, WordCounter.countWords("Mary---Jane.", emptyStopWords).getOverallCount());

        Assert.assertEquals(0, WordCounter.countWords("-Mary joe-", emptyStopWords).getOverallCount());
        Assert.assertEquals(0, WordCounter.countWords("-Mary  -a-my- joe-", emptyStopWords).getOverallCount());

        Assert.assertEquals(0, WordCounter.countWords("- - ----", new HashSet<>()).getOverallCount());
        Assert.assertEquals(0, WordCounter.countWords("-Mary---Joe-  --fa-", new HashSet<>()).getOverallCount());
    }

    @Test
    public void countWordsWithNoStopWordsButWithWeirdInterpunctions() {
        final Set<String> emptyStopWords = Collections.emptySet();
        Assert.assertEquals(4, WordCounter.countWords(".Mary.had,a lamb", emptyStopWords).getOverallCount());
        Assert.assertEquals(0, WordCounter.countWords(".,", emptyStopWords).getOverallCount());
    }

    @Test
    public void countWordsWithNoStopWordsButWithWeirdWhitespaces() {
        final Set<String> emptyStopWords = Collections.emptySet();

        Assert.assertEquals(2, WordCounter.countWords("\tMary\t\t     had.    ", emptyStopWords).getOverallCount());
        Assert.assertEquals(4, WordCounter.countWords(".Mary\thad,a lamb", emptyStopWords).getOverallCount());
    }

    @Test
    public void countWordsWithNoStopWordsButWithWeirdSymbols() {
        final Set<String> emptyStopWords = Collections.emptySet();

        Assert.assertEquals(0, WordCounter.countWords("H$ad", emptyStopWords).getOverallCount());
        Assert.assertEquals(0, WordCounter.countWords("541", emptyStopWords).getOverallCount());
        Assert.assertEquals(2, WordCounter.countWords("Mary h$d & lamb", emptyStopWords).getOverallCount());
    }

    @Test
    public void countWordsTestWithSomeStopWords() {
        final Set<String> stopWords = new HashSet<>(Arrays.asList("Mary", "LAMB"));
        Assert.assertEquals(2, WordCounter.countWords("Mary had a lamb", stopWords).getOverallCount());
        Assert.assertEquals(0, WordCounter.countWords("Mary, MARY, mary, LAMB, Lamb", stopWords).getOverallCount());
        Assert.assertEquals(4, WordCounter.countWords("Joe had a sheep", stopWords).getOverallCount());

        final Set<String> strangeStopWords = new HashSet<>(Collections.singletonList("Mary had a lamb"));
        Assert.assertEquals(4, WordCounter.countWords("Mary had a lamb", strangeStopWords).getOverallCount());
    }

    @Test
    public void countUniqWordsWithSomeStopWords() {
        final Set<String> stopWords = new HashSet<>(Arrays.asList("Mary", "LAMB"));
        Assert.assertEquals(0, WordCounter.countWords("Mary Mary mary", stopWords).getUniqueCount());
        Assert.assertEquals(1, WordCounter.countWords("Joe Joe joe Lamb lamb", stopWords).getUniqueCount());
        Assert.assertEquals(2, WordCounter.countWords("Joe Cow joe Lamb lamb", stopWords).getUniqueCount());

        final Set<String> strangeStopWords = new HashSet<>(Collections.singletonList("Mary mary"));
        Assert.assertEquals(1, WordCounter.countWords("Mary Mary", strangeStopWords).getUniqueCount());
    }

    @Test
    public void countUniqWordsNoStopWords() {
        final Set<String> emptyStopWords = Collections.emptySet();
        Assert.assertEquals(1, WordCounter.countWords("Mary Mary mary", emptyStopWords).getUniqueCount());
        Assert.assertEquals(3, WordCounter.countWords("Mary had a mary", emptyStopWords).getUniqueCount());
        Assert.assertEquals(3, WordCounter.countWords("Mary had had a a mary", emptyStopWords).getUniqueCount());
        Assert.assertEquals(1, WordCounter.countWords("Mary-Mary-mary", emptyStopWords).getUniqueCount());
    }
}
