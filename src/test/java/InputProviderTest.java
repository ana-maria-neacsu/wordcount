import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class InputProviderTest {

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

    private final InputProvider wordCounter = new InputProvider(new TestReader());

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
        final InputProvider wordCounter = new InputProvider(new ErroringTestReader());
        Assert.assertEquals(0, wordCounter.getStopWords().size());

    }
}
