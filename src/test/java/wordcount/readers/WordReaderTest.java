package wordcount.readers;

import org.junit.Test;
import wordcount.readers.WordReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;

public class WordReaderTest {

    @Test
    public void testEmpty() {
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        WordReader wordReader = new WordReader(inputStream);

        Collection<String> words = wordReader.read();

        assert words.isEmpty();
    }


    @Test
    public void testSingleWord() {
        InputStream inputStream = new ByteArrayInputStream("hfkjlhAWkdhlkh".getBytes());
        WordReader wordReader = new WordReader(inputStream);

        Collection<String> words = wordReader.read();

        assert words.size() == 1;
    }

    @Test
    public void testMixed() {
        InputStream inputStream = new ByteArrayInputStream("hf_kjlhAW kdh 555lkh".getBytes());
        WordReader wordReader = new WordReader(inputStream);

        Collection<String> words = wordReader.read();

        assert words.size() == 7;
    }

    @Test
    public void testNonAlphabetic() {
        InputStream inputStream = new ByteArrayInputStream("555".getBytes());
        WordReader wordReader = new WordReader(inputStream);

        Collection<String> words = wordReader.read();

        assert words.size() == 2;
    }

    @Test
    public void testSimpleSentence() {
        InputStream inputStream = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        WordReader wordReader = new WordReader(inputStream);

        Collection<String> words = wordReader.read();

        assert words.size() == 5;
    }
}
