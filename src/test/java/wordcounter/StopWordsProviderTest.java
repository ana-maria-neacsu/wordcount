package wordcounter;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import wordcounter.exceptions.StopWordsProviderException;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StopWordsProviderTest {

    @Test
    public void should_throw_exception_when_unable_to_find_the_file() {
        assertThrows(StopWordsProviderException.class, this::provideNonExistingFilename);
    }

    private void provideNonExistingFilename() {
        StopWordsProvider stopWordsProvider = new StopWordsProvider("asfds");
        stopWordsProvider.getStopWords();
    }

    @Test
    public void should_return_stop_words(){
        StopWordsProvider stopWordsProvider = new StopWordsProvider("stopwords_test.txt");
        Set<String> expectedStopWords = new HashSet<>(asList("the", "a", "on", "off"));

        Set<String> stopWords = stopWordsProvider.getStopWords();

        assertEquals(stopWords, expectedStopWords);
    }

}
