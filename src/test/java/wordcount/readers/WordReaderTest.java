package wordcount.readers;

import org.junit.Test;
import wordcount.readers.WordReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;

public class WordReaderTest {

    WordReader wordReader = new WordReader();

    @Test
    public void testEmpty() {
        InputStream inputStream = new ByteArrayInputStream("".getBytes());

        Collection<String> words = wordReader.read(inputStream);

        assert words.isEmpty();
    }


    @Test
    public void testSingleWord() {
        InputStream inputStream = new ByteArrayInputStream("hfkjlhAWkdhlkh".getBytes());

        Collection<String> words = wordReader.read(inputStream);

        assert words.size() == 1;
    }

    @Test
    public void testMixed() {
        InputStream inputStream = new ByteArrayInputStream("hf_kjlhAW kdh 555lkh".getBytes());

        Collection<String> words = wordReader.read(inputStream);

        assert words.size() == 7;
    }

    @Test
    public void testNonAlphabetic() {
        InputStream inputStream = new ByteArrayInputStream("555".getBytes());

        Collection<String> words = wordReader.read(inputStream);

        assert words.size() == 2;
    }

    @Test
    public void testSimpleSentence() {
        InputStream inputStream = new ByteArrayInputStream("Mary had a little lamb".getBytes());

        Collection<String> words = wordReader.read(inputStream);

        assert words.size() == 5;
    }
}
