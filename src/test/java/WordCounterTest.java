import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {

    private static class ErroringTestReader implements InputReader {

        @Override
        public String readStandardInput() {
            return null;
        }

        @Override
        public String readFile(String file) throws FileNotFoundException {
            throw new FileNotFoundException("File not found");
        }
    }

    private static class TestReader implements InputReader {

        @Override
        public String readStandardInput() {
            return "Mary has an input lamb";
        }

        @Override
        public String readFile(String file) {
            if (file.equals("input.txt")) {
                return "Mary has a file lamb\n" +
                        "and another file cow";
            } else if (file.equals("stopwords.txt")) {
                return "the\n" +
                        "a\n" +
                        "on\n" +
                        "off";
            } else {
                throw new Error("Unexpected file name");
            }
        }
    }

    private final WordCounter wordCounter = new WordCounter(new TestReader());

    @Test
    public void testGetInput() throws FileNotFoundException {
        // file input
        Assert.assertEquals("Mary has a file lamb\nand another file cow",
                wordCounter.getInput(new String[]{"input.txt"}));

        // standard input
        Assert.assertEquals("Mary has an input lamb", wordCounter.getInput(new String[]{}));
    }

    @Test
    public void testGetStopWords() {
        final Set<String> expectedStopWords = new HashSet<>(Arrays.asList("the", "a", "on", "off"));
        Assert.assertEquals(expectedStopWords, wordCounter.getStopWords());
    }

    @Test
    public void testNoStopWordsFilePresent() {
        // if no file exists should return empty set
        final WordCounter wordCounter = new WordCounter(new ErroringTestReader());
        Assert.assertEquals(0, wordCounter.getStopWords().size());

    }

    @Test
    public void testInput() {
    }

    @Test
    public void countWordsTestWithNoStopWords() {

        // ordinary lines
        Assert.assertEquals(4,wordCounter.countWords("Mary had a lamb", new HashSet<String>()));
        Assert.assertEquals(4,wordCounter.countWords("Mary, had a lamb.", new HashSet<String>()));
        Assert.assertEquals(1,wordCounter.countWords("Mary", new HashSet<String>()));
        Assert.assertEquals(8,wordCounter.countWords("Mary had a lamb. And Joe had two.", new HashSet<String>()));
        Assert.assertEquals(6,wordCounter.countWords("Mary had 1 lamb. And Joe had 2.", new HashSet<String>()));

        // weird input
        Assert.assertEquals(4,wordCounter.countWords("MaRY HAD A LaMb.", new HashSet<String>()));
        Assert.assertEquals(4,wordCounter.countWords(".Mary.had,a lamb", new HashSet<String>()));
        Assert.assertEquals(0,wordCounter.countWords("", new HashSet<String>()));
        Assert.assertEquals(0,wordCounter.countWords("H$ad", new HashSet<String>()));
        Assert.assertEquals(0,wordCounter.countWords("541", new HashSet<String>()));
        Assert.assertEquals(0,wordCounter.countWords(".,", new HashSet<String>()));
        Assert.assertEquals(4,wordCounter.countWords(".Mary\thad,a lamb", new HashSet<String>()));
        Assert.assertEquals(2,wordCounter.countWords("\tMary\t\t     had.    ", new HashSet<String>()));
        Assert.assertEquals(2,wordCounter.countWords("Mary h$d & lamb", new HashSet<String>()));
    }

    @Test
    public void countWordsTestWithSomeStopWords() {
        final Set<String> stopWords = new HashSet<>(Arrays.asList("Mary", "LAMB"));
        Assert.assertEquals(2, wordCounter.countWords("Mary had a lamb", stopWords));
        Assert.assertEquals(0, wordCounter.countWords("Mary, MARY, mary, LAMB, Lamb", stopWords));
        Assert.assertEquals(4, wordCounter.countWords("Joe had a sheep", stopWords));

        final Set<String> strangeStopWords = new HashSet<>(Collections.singletonList("Mary had a lamb"));
        Assert.assertEquals(4, wordCounter.countWords("Mary had a lamb", strangeStopWords));

        final Set<String> emptyStopWords = Collections.emptySet();
        Assert.assertEquals(4, wordCounter.countWords("Mary had a lamb", emptyStopWords));
    }
}
