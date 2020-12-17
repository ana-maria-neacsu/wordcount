import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class WordReaderTest {

    WordReader wordReader = new WordReader();

    @Test
    public void testEmpty() {
        InputStream inputStream = new ByteArrayInputStream("".getBytes());

        List<String> words = wordReader.readWords(inputStream);

        assert words.isEmpty();
    }


    @Test
    public void testSingleWord() {
        InputStream inputStream = new ByteArrayInputStream("hfkjlhAWkdhlkh".getBytes());

        List<String> words = wordReader.readWords(inputStream);

        assert words.size() == 1;
    }

    @Test
    public void testMixed() {
        InputStream inputStream = new ByteArrayInputStream("hfkjlhAW kdh 555lkh".getBytes());

        List<String> words = wordReader.readWords(inputStream);

        assert words.size() == 6;
    }
}
