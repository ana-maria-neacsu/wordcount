package wordcount.readers;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

public class StopWordReaderTest {

    @Test
    public void testEmpty() {
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        StopWordReader stopWordReader = new StopWordReader(inputStream);

        Set<String> words = stopWordReader.read();

        assert words.isEmpty();
    }

    @Test
    public void testEmptyLines() {
        InputStream inputStream = new ByteArrayInputStream("\n\n".getBytes());
        StopWordReader stopWordReader = new StopWordReader(inputStream);

        Set<String> words = stopWordReader.read();

        assert words.isEmpty();
    }


    @Test
    public void testSingleWord() {
        InputStream inputStream = new ByteArrayInputStream("hfkjlhAWkdhlkh".getBytes());
        StopWordReader stopWordReader = new StopWordReader(inputStream);

        Set<String> words = stopWordReader.read();

        assert words.size() == 1;
    }

    @Test
    public void testMultipleLines() {
        InputStream inputStream = new ByteArrayInputStream("asdf\nasdfgh".getBytes());
        StopWordReader stopWordReader = new StopWordReader(inputStream);

        Set<String> words = stopWordReader.read();

        assert words.size() == 2;
    }

    @Test
    public void testDuplicates() {
        InputStream inputStream = new ByteArrayInputStream("a\na\na".getBytes());
        StopWordReader stopWordReader = new StopWordReader(inputStream);

        Set<String> words = stopWordReader.read();

        assert words.size() == 1;
    }

    @Test
    public void testExampleFile() {
        InputStream inputStream = StopWordReaderTest.class.getClassLoader().getResourceAsStream("stopwords.txt");
        StopWordReader stopWordReader = new StopWordReader(inputStream);

        Set<String> words = stopWordReader.read();

        assert words.size() == 4;
    }
}
