package wordcount.readers;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

public class StopWordReaderTest {

    StopWordReader stopWordReader = new StopWordReader();

    @Test
    public void testEmpty() {
        InputStream inputStream = new ByteArrayInputStream("".getBytes());

        Set<String> words = stopWordReader.read(inputStream);

        assert words.isEmpty();
    }

    @Test
    public void testEmptyLines() {
        InputStream inputStream = new ByteArrayInputStream("\n\n".getBytes());

        Set<String> words = stopWordReader.read(inputStream);

        System.out.println(words.size());
        assert words.isEmpty();
    }


    @Test
    public void testSingleWord() {
        InputStream inputStream = new ByteArrayInputStream("hfkjlhAWkdhlkh".getBytes());

        Set<String> words = stopWordReader.read(inputStream);

        assert words.size() == 1;
    }

    @Test
    public void testMultipleLines() {
        InputStream inputStream = new ByteArrayInputStream("asdf\nasdfgh".getBytes());

        Set<String> words = stopWordReader.read(inputStream);

        assert words.size() == 2;
    }

    @Test
    public void testDuplicates() {
        InputStream inputStream = new ByteArrayInputStream("a\na\na".getBytes());

        Set<String> words = stopWordReader.read(inputStream);

        assert words.size() == 1;
    }

    @Test
    public void testExampleFile() {
        InputStream inputStream = StopWordReaderTest.class.getClassLoader().getResourceAsStream("stopwords.txt");

        Set<String> words = stopWordReader.read(inputStream);

        assert words.size() == 4;
    }
}
